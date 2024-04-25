package ua.kiev.minaeva.ocp.streams;

import java.util.stream.IntStream;

public class IntStreamRange {

    public static void main(String[] args) {
        System.out.println(IntStream.range(10,1).count()); // 0
        System.out.println(IntStream.range(0,10).count()); // 10
        System.out.println(IntStream.range(10,10).count()); // 0
    }
}
