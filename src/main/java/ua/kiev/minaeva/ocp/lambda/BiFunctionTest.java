package ua.kiev.minaeva.ocp.lambda;

import java.util.function.BiFunction;

public class BiFunctionTest {

    public static void main(String[] args) {
//            BiFunction<Integer, Integer, Character> compFunc = (i, j) -> i + j; // NO
        BiFunction<Integer, Integer, Character> compFunc = (i, j) -> (char) (i + j); // A
        System.out.println(compFunc.apply(0, 65));
    }
}
