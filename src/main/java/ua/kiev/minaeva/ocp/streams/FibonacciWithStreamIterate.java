package ua.kiev.minaeva.ocp.streams;

import java.util.stream.Stream;

public class FibonacciWithStreamIterate {

    public static void main(String[] args) {
//        long[] init = new long[]{1, 1};
//        System.out.println("1 1 2 3 5 8 13 21");
//        for (int i = 2; i <= 80; i++) {
//            long sum = init[0] + init[1];
//            init[0] = init[1];
//            init[1] = sum;
//            System.out.println(i + "th element is " + init[0]);
//        }

        int iteration = 1;
        while (iteration <= 80) {
            Stream.iterate(new long[]{1, 1}, e -> new long[]{e[1], e[0] + e[1]})
                    .limit(iteration++)
                    .forEach(el -> System.out.print(el[0] + " "));
            System.out.println();
        }
    }
}
