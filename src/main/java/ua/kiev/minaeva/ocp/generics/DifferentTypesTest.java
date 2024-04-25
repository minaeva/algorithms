package ua.kiev.minaeva.ocp.generics;

public class DifferentTypesTest<T> {
    private T t;

    public T get() {
        return t;
    }

    public void set(T t) {
        this.t = t;
    }

    public static void main(String args[]) {
        DifferentTypesTest obj = new DifferentTypesTest(); // warning raw use of parametrized class
        obj.set("OCP");
        obj.set(85);
        obj.set('%');

        System.out.println(obj.get()); // --> %
    }
}