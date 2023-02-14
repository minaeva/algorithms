package ua.kiev.minaeva;

import java.util.ArrayList;
import java.util.List;

public class ForEachInList {

    public static void main(String[] args) {

        List<Integer> leaveDatesList = new ArrayList<>();

//.....inserted value in list.......
//    Way 1: printing a list in a for loop

        for (int i = 0; i < leaveDatesList.size(); i++) {
            System.out.println(leaveDatesList.get(i));
        }
//    Way 2: printing the list in a forEach, for loop

        for (Integer leave : leaveDatesList) {
            System.out.println(leave);
        }
//    Way 3: printing the list in java 8

        leaveDatesList.forEach(System.out::println);
    }

}
