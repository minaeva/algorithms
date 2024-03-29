package ua.kiev.minaeva.ocp.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorForEach {

    // you cannot add or remove inside an enhanced for
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        Iterator<Integer> iterator = list.iterator();

        // YES
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        // NO: ConcurrentModificationException - works over iterator's snapshot
//        for (int e : list) {
//            list.add(e);
//        }

        // NO: IndexOutOfBoundsException
//        for (int e : list) {
//            list.remove(e);
//        }

        // YES
//        while (iterator.hasNext()) {
//            if (iterator.next() == 20) {
//                iterator.remove();
//            }
//        }
//        System.out.println(list); // [10,30]


    }
}
