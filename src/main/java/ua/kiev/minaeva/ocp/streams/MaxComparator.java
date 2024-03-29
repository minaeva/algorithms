package ua.kiev.minaeva.ocp.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxComparator {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 20, 8);

        System.out.println(list.stream().max(Comparator.comparing(a -> a)).get()); //20
        System.out.println(list.stream().max(Integer::compareTo).get()); //20
        System.out.println();
        System.out.println(list.stream().max(Comparator.naturalOrder()).get()); //20
        System.out.println(list.stream().max(Comparator.comparingInt(Integer::intValue)).get()); //20
        System.out.println(list.stream().max(Comparator.comparingInt(Integer::valueOf)).get()); //20
        System.out.println();
        System.out.println(list.stream().max(Integer::sum).get()); //10
        System.out.println(list.stream().max(Integer::max).get()); //10
        System.out.println();
        System.out.println(list.stream().max(Comparator.reverseOrder()).get()); //8
    }
}
