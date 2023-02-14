package ua.kiev.minaeva;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//Write a Java Program to count the number of words in a string using HashMap
//input "This this is is done by Roman Roman"
//output {by=1, this=1, This=1, Roman=2, is=2, done=1}
public class CountStrings {


    public static void main(String[] args) {
        String input = "This this is is done by Roman Roman";
        List<String> words = Arrays.asList(input.split(" "));
        Map<String, Integer> collect = words
                .stream()
//                .collect(Collectors.toMap(word -> word, word -> 1, Integer::sum));
                .collect(Collectors.toMap(Function.identity(), word -> 1, Integer::sum));
        System.out.println(collect);
    }


    public static void listToPrint(String[] args)
    {
        List<String> list = Arrays.asList(
                "hello", "bye", "ciao", "bye", "ciao");
        Map<String, Integer> counts = list.parallelStream().
                collect(Collectors.toMap(
                        w -> w, w -> 1, Integer::sum));
        System.out.println(counts);
    }
}
