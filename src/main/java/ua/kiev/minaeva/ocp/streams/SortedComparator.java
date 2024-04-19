package ua.kiev.minaeva.ocp.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortedComparator {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 20, 8);

        // [8, 10, 20]
        System.out.println(list.stream().sorted(Comparator.comparing(a -> a)).toList());
        System.out.println(list.stream().sorted(Integer::compareTo).toList());
        System.out.println(list.stream().sorted(Comparator.naturalOrder()).toList());
        System.out.println(list.stream().sorted(Comparator.comparingInt(Integer::intValue)).toList());
        System.out.println(list.stream().sorted(Comparator.comparingInt(Integer::valueOf)).toList());
        System.out.println();
        // [10, 20, 8]
        System.out.println(list.stream().sorted(Integer::sum).toList());
        System.out.println(list.stream().sorted(Integer::max).toList());
        System.out.println();
        // [20, 10, 8]
        System.out.println(list.stream().sorted(Comparator.reverseOrder()).toList());

    }
}
