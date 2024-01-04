package ua.kiev.minaeva.pub_sub;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Callable;

import static ua.kiev.minaeva.pub_sub.Constants.POISON_PILL;

public class Consumer implements Callable<Integer> {

    private final Buffer<Integer> buffer;
    private static final Logger log = LogManager.getLogger(Consumer.class);

    public Consumer(Buffer<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public Integer call() {
        try {
            Integer element = buffer.remove();
            if (element.equals(POISON_PILL)) {
                return -1;
            }
            return element;
        } catch (InterruptedException e) {
            log.error("Exception ", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
