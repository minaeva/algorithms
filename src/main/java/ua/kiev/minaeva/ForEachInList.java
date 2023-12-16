package ua.kiev.minaeva;

import java.util.ArrayList;
import java.util.List;

public class ForEachInList {

    public static void main(String[] args) {

        List<Integer> leaveDatesList = new ArrayList<>();

        for (int i = 0; i < leaveDatesList.size(); i++) {
            System.out.println(leaveDatesList.get(i));
        }
        for (Integer leave : leaveDatesList) {
            System.out.println(leave);
        }
        leaveDatesList.forEach(System.out::println);
    }

}
