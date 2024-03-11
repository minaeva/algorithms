package ua.kiev.minaeva.ocp.generics;


//enum EnumGenerecis<T> {}

import java.util.ArrayList;
import java.util.List;

enum Season {
    WINTER;

    <T> void run(T t) {
        System.out.println(t);
    }
}

class One { //no need in One<T>

    <T> void run(T t) {
        System.out.println(t);
    }
}

class Two<T> {

    void run(T t) {
        System.out.println(t);
    }
}

class Three<T> {

    {
//        new T(); // NO
    }
}

class MyException extends Exception {} // YES
//class MyException2<T> extends Exception {} // NO

public class Restrictions {

    public static void main(String[] args) {
        List<? super Number> list = new ArrayList<>(); //super - to add
        list.add(1);
//        List<? super Number> list2 = new ArrayList<? super Number>(); // NO
//        List<? super Number> list2 = new ArrayList<? super Integer>(); // NO
        List<? super Integer> list2 = new ArrayList<Number>(); // YES
        List<? super Number> list3 = new ArrayList<Number>(); // YES
    }

    public Object getObj() {
        return null;
    }

    public void instanceOfGeneric() {
        Object o = getObj();
//        if (o instanceof Three<String>) { // NO
//            System.out.println("cannot use in instanceof");
//        }
    }

    public void arraysLimitation() {
        Three [] arr1 = null; // YES
        Three<String> [] arr2 = null; // YES
//        Three<String> [] arr2 = {}; // NO - cannot create parametrized array
    }

    public void primitiveLimitations() {
//        Three<int> three = null; // NO
        Three<int[]> three = null; // YES
    }
}

class EqualsHashCode<T> {
    T t;

    @Override
    public boolean equals(Object t) { // YES
//    public boolean equals(T t) { // NO -  becomes (Object t) because of the type erasure
        return false;
    }
}
