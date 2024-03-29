package ua.kiev.minaeva.ocp.collections;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeRemoveAbsent {
    public static void main(String[] args) {
        Deque<Character> chars = new ArrayDeque<>();
        chars.add('A');
        chars.remove();
//        chars.remove(); // NoSuchElementException runtime
        chars.pollLast(); // returns null if this deque is empty

        System.out.println(chars);
    }
}
