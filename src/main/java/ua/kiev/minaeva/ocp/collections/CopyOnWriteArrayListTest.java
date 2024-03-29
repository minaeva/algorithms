package ua.kiev.minaeva.ocp.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListTest {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("Melon");
        list1.add("Apple");
        list1.add("Banana");
        list1.add("Mango");
        List<String> list2 = new CopyOnWriteArrayList<>(list1);
        for(String s : list2) {
            if(s.startsWith("M")){
                list2.remove(s);
            }
        }
        System.out.println(list1); //[Melon, Apple, Banana, Mango]
        System.out.println(list2); //[Apple, Banana]

    }
}
