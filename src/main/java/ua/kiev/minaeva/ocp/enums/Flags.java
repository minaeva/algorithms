package ua.kiev.minaeva.ocp.enums;

enum FlagsEnum {
    TRUE, FALSE;

    FlagsEnum() {
        System.out.println("HELLO");
    }
}

public class Flags {
    public static void main(String[] args) {
        FlagsEnum flags = FlagsEnum.TRUE; // prints HELLO twice
    }
}
