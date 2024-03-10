package ua.kiev.minaeva.ocp.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExtendsExample {

    void numberToIntegerCastNotWorking() {
        Number num = null;
        Integer integer = null;
        num = integer; //works

        List<Number> nums = new ArrayList<>();
        List<Integer> ints = new ArrayList<>();
//        nums = ints; //won't work
    }

    void whyWeNeedExtends() {
        List<? extends Number> nBox = null;
        List<Integer> iBox = null;
        nBox = iBox;
    }

    void addingWontWork() {
//        List<? extends Number> nums = new ArrayList<>();
        List<? extends Number> nums = Arrays.asList(1, 2L, 3.0);
//        nums.add(4L); // won't work

        List<? extends Number> num2 = new ArrayList<>();
//        nums.add(10); //won't work
    }

    void gettingWorks() {
        List<? extends Number> numbers = Arrays.asList(1, 2.0, 3L);
        System.out.println(numbers.get(0).getClass().getName());
        System.out.println(numbers.get(1).getClass().getName());
        System.out.println(numbers.get(2).getClass().getName());

//        List<? extends Number> numbersWithDiamonds = Arrays.<Integer>asList(1, 2.0, 3L); //NO
//        List<? extends Number> numberExtends = Arrays.<? extends Number>asList(1, 2, 3); //NO
        List<? extends Number> numberInteger = Arrays.<Integer>asList(1, 2, 3); //YES
        List<? extends Number> numberNumber = Arrays.<Number>asList(1, 2.0, 3L); //YES
    }
}
