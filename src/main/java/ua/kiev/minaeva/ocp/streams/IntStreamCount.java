package ua.kiev.minaeva.ocp.streams;

import java.util.List;
import java.util.stream.IntStream;


public class IntStreamCount {

    public static void main(String[] args) {
        System.out.println(IntStream.range(10, 1).count()); // 0
        System.out.println(IntStream.range(10, 10).count()); // 0
        System.out.println(IntStream.range(1, 10).count()); // 9
        IntStream.range(1, 10)
                .forEach(System.out::print); //123456789

        System.out.println();
        List.of("1", "2", "3").stream().map(String::toUpperCase).toList();
        System.out.println(IntStream.range(1, 10).toArray());
    }
}
