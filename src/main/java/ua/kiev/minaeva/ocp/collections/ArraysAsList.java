package ua.kiev.minaeva.ocp.collections;

import java.util.Arrays;
import java.util.List;

public class ArraysAsList {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0,2,4,6,8);
        list.replaceAll(i -> i + 1);
        System.out.println(list); //[1, 3, 5, 7, 9]
    }
}
