package ua.kiev.minaeva.pub_sub;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static ua.kiev.minaeva.pub_sub.Constants.PRODUCER_TIMEOUT;

public class Producer implements Runnable {

    private final Buffer<Integer> buffer;
    private static int counter = 1;
    private static final Object lock = new Object();

    private static final Logger log = LogManager.getLogger(Producer.class);

    public Producer(Buffer<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            int current;
            synchronized (lock) {
                current = counter++;
            }
            log.info("Trying to send " + current);
            boolean success = buffer.tryAdd(current, PRODUCER_TIMEOUT);
            if (success) {
                log.info("Sent " + current);
            } else {
                log.info("Failed to send " + current + " due to timeout");
            }
        } catch (InterruptedException e) {
            log.error("Exception ", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
