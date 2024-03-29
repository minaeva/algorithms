package ua.kiev.minaeva.ocp.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Printer implements Runnable {
    public void run() {
        System.out.println("Printing");
    }
}

public class ExecutorServiceStart {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(1);
        es.submit(new Printer());
        es.execute(new Printer());

//        es.start(new Printer()); // NO
//        es.run(new Printer()); // NO
        es.shutdown();
    }
}
