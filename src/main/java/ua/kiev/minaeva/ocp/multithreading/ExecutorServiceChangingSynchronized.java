package ua.kiev.minaeva.ocp.multithreading;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Accumulator {
    private List<Integer> list = new ArrayList<>();

    public synchronized void accumulate(int i) {
        list.add(i);
    }

    public List<Integer> getList() {
        return list;
    }
}

public class ExecutorServiceChangingSynchronized {
    public static void main(String[] args) {
        ExecutorService s = Executors.newFixedThreadPool(1000);
        Accumulator a = new Accumulator();
        for (int i = 1; i <= 1000; i++) {
            int x = i;
            s.execute(() -> a.accumulate(x));
        }
        s.shutdown();
        System.out.println(a.getList());
        System.out.println(a.getList().size());
    }
}