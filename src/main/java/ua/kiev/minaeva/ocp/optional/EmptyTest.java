package ua.kiev.minaeva.ocp.optional;

import java.util.OptionalInt;

public class EmptyTest extends RuntimeException { // OK
//public class EmptyTest extends Exception { // NO Unhandled exception EmptyTest

    public static void main(String[] args) {
        OptionalInt optional = OptionalInt.empty();
        System.out.println(optional.orElseThrow(EmptyTest::new));
    }
}