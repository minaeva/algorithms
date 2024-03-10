package ua.kiev.minaeva.ocp.generics;

public class StaticExample<T> {

    // field cannot be static
    //    static T thing2;

    // method can be static
    static <T1> void method(T1 t1) {
    }

}
