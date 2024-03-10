package ua.kiev.minaeva.ocp.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PECS {

// Producer Extends Consumer Super

// GAP = Get and Put

// pUt -> sUper
// gEt -> ExtEnds

    public static void main(String[] args) {
        MyCollection<Number> myCollection = new MyCollection<>();
        List<Integer> integers = new ArrayList<>();
        myCollection.setCollection(integers);
    }
}

class MyCollection<T> {
    Collection<? extends T> collection;

    void setCollection(Collection<? extends T> collection) {
        this.collection = collection;
    }
}