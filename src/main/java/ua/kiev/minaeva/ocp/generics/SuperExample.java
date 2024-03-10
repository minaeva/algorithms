package ua.kiev.minaeva.ocp.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//public class SuperExample<T super Number>{ //NO --> compiler doesn't know what class cast to use
public class SuperExample<T extends Number> {

    public static void main(String[] args) {

        canCreateWithEverybody();
//        list.add(new GrandPa()); //NO
    }

    static void cannotAddGrandPa() {
        List<? super Father> list = new ArrayList<>();
        list.add(new Son());
        list.add(new Father());
    }

    static void canCreateWithEverybody() {
        List<? super Father> list = Arrays.asList(new Son(), new Father(), new GrandPa());
//        list.add(new Son()); // NO Arrays.asList() creates immutable list
//        list.add(new Father());

        System.out.println(list.get(0).getClass().getName());
        System.out.println(list.get(1).getClass().getName());
        System.out.println(list.get(2).getClass().getName());

//        Son son = list.get(0); // NO
//        Father son = list.get(0); // NO
//        GrandPa son = list.get(0); // NO
        Son son = (Son) list.get(0);
    }
}

class GrandPa {

}

class Father extends GrandPa {

}

class Son extends Father {

}