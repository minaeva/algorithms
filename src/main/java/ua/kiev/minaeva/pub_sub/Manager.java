package ua.kiev.minaeva.pub_sub;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static ua.kiev.minaeva.pub_sub.Constants.*;

public class Manager {

    private static final Logger log = LogManager.getLogger(Manager.class);

    public static void main(String[] args) throws InterruptedException {

        Buffer<Integer> sharedBuffer = new Buffer<>(BUFFER_CAPACITY);

        ExecutorService consumerExecutor = Executors.newFixedThreadPool(CONSUMER_QUANTITY);
        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < CONSUMER_QUANTITY; i++) {
            Consumer consumer = new Consumer(sharedBuffer);
            futures.add(consumerExecutor.submit(consumer));
        }

        List<Thread> producerThreads = new ArrayList<>();

        for (int i = 0; i < PRODUCER_QUANTITY; i++) {
            Producer producer = new Producer(sharedBuffer);
            Thread producerThread = new Thread(producer);
            producerThread.start();
            producerThreads.add(producerThread);
        }

        log.info("*** Start producing");
        for (Thread producerThread : producerThreads) {
            producerThread.join(MANAGER_TIMEOUT);
        }
        log.info("*** Producers have been joined");

        for (int i = 0; i < CONSUMER_QUANTITY; i++) {
            sharedBuffer.addPoisonPill();
        }

        futures.forEach(future -> {
                    try {
                        Integer consumedValue = future.get();
                        if (consumedValue != -1) {
                            log.info("received in manager " + consumedValue);
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException(e);
                    } catch (ExecutionException e) {
                        log.error("Exception in consumer execution: " + e.getCause());
                    }
                }
        );

        consumerExecutor.shutdown();
        try {
            if (!consumerExecutor.awaitTermination(CONSUMER_TIMEOUT, TimeUnit.MILLISECONDS)) {
                consumerExecutor.shutdownNow();
            }
        } catch (InterruptedException e) {
            consumerExecutor.shutdownNow();
            Thread.currentThread().interrupt();
        }

    }
}
