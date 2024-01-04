package ua.kiev.minaeva.pub_sub;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.Queue;

import static ua.kiev.minaeva.pub_sub.Constants.POISON_PILL;

public class Buffer<T> {

    private final Queue<T> buffer;
    private final int capacity;

    private static final Logger log = LogManager.getLogger(Buffer.class);

    public Buffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new LinkedList<>();
    }

    @SuppressWarnings("unchecked")
    public synchronized void addPoisonPill() {
        buffer.add((T) POISON_PILL);
        notifyAll();
    }

    public synchronized boolean tryAdd(T element, long timeout) throws InterruptedException {
        long endTime = System.currentTimeMillis() + timeout;
        while (buffer.size() == capacity) {
            long waitTime = endTime - System.currentTimeMillis();
            if (waitTime <= 0) {
                return false;
            }
            wait(waitTime);
        }
        buffer.add(element);
        notifyAll();
        return true;
    }

    public synchronized T remove() throws InterruptedException {
        while (buffer.isEmpty()) {
            log.info("buffer is empty => Waiting");
            wait();
        }
        T element = buffer.remove();
        notifyAll();
        return element;
    }
}
