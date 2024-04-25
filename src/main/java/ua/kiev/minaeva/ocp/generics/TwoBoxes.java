package ua.kiev.minaeva.ocp.generics;

public class TwoBoxes<T> {
    T value;

    public TwoBoxes(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public static void main(String[] args) {
        TwoBoxes<String> one = new TwoBoxes<>("a string");
        TwoBoxes<Integer> two = new TwoBoxes<>(123);
        System.out.print(one.getValue());
        System.out.print(two.getValue());
        // a string123
    }
}