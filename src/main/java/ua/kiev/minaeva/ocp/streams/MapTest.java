package ua.kiev.minaeva.ocp.streams;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MapTest {

    List<Integer> list = List.of(3, 7, 12, 3, 4);

    List<String> intStrings = List.of("5", "0", "177", "-1");

    //Create a stream of integers and use map to multiply each element by 2.
    void multiplyBy2() {
        List<Integer> result = list.stream().map(el -> el * 2).toList();
        System.out.println(result);
    }

    //Use map to convert a stream of strings to uppercase.
    void toUppercase() {
        List<String> strings = List.of("a", "list", "sUper", "enD");
        List<String> result = strings.stream().map(String::toUpperCase).toList();
        System.out.println(result);
    }

    //Create a stream of strings representing numbers and use map to parse them into integers.
    void parseToInt() {
        List<Integer> result = intStrings.stream().map(Integer::parseInt).toList();
        System.out.println(result);
    }

    //Use map to extract the first character of each string in a stream of strings.
    void toChars() {
        List<String> strings = List.of("a", "list", "sUper", "enD");
        List<Character> result = strings.stream().map(element -> element.charAt(0)).toList();
        System.out.println(result);
    }

    //Create a stream of doubles and use map to round each element to the nearest integer.
    void roundToInt() {
        List<Double> doubles = List.of(3.2, 7.07, 12.0, 3.333, -4.9);
        List<Integer> result = doubles.stream()
                .map(Math::round).map(Math::toIntExact).toList();
        System.out.println(result);
    }

    //Create a stream of strings and use map to count the number of characters in each string.
    void countLengthsToMap() {
        List<String> strings = List.of("a", "list", "sUper", "enD");

        Map<String, Integer> map = new HashMap<>();
        strings.forEach(el -> map.put(el, el.length()));
        System.out.println(map);

        Map<String, Integer> map2 = strings.stream()
                .collect(Collectors.toMap(s -> s, String::length));
        System.out.println(map2);
    }

    //Create a stream of strings and use map to count the number of characters in each string, use element's index as a key
    void countLengthsToMapWithIndexAsKey() {
        List<String> strings = List.of("a", "list", "sUper", "enD");

        Map<Integer, Integer> map = IntStream.range(0, strings.size())
                .boxed()
                .collect(Collectors.toMap(
                        index -> index,
                        index -> strings.get(index).length()
                ));

        System.out.println(map);
    }

    //Use map to transform a stream of strings into a stream of their lengths.
    void transformToLengths() {
        List<String> strings = List.of("a", "list", "sUper", "enD");
        List<Integer> lengths = strings.stream().map(String::length).toList();
        System.out.println(lengths);
    }

    //Convert list of strings into a map where key is the first letter, value is the longest string with this letter
    void transformToMapOfCharString() {
        List<String> strings = List.of("a", "list", "sUper", "enD", "A", "elephant");
        Map<Character, String> map = strings.stream()
                .collect(Collectors.toMap(el -> el.charAt(0), el -> el, (one, two) -> two.length() > one.length() ? two : one));
        System.out.println(map);
    }

    // convert list of integers into map, where key is the integer, value is the counter
    void transformToMapOfIntCounter() {
        List<Integer> integers = List.of(22, 7, 5, 5, 4, 3, 3, 2, 2, 2, 1, 1, 1, 1, 1);
        Map<Integer,Integer> map = integers.stream()
                .collect(Collectors.toMap(Function.identity(), value -> 1, Integer::sum));
        System.out.println(map);
    }

    // convert list of integers into map, where key is the integer, value is the accumulated sum
    void transformToMapOfIntSumOfValues() {
        List<Integer> integers = List.of(22, 7, 5, 5, 4, 3, 3, 2, 2, 2, 1, 1, 1, 1, 1);
        Map<Integer,Integer> map = integers.stream()
                .collect(Collectors.toMap(Function.identity(), value -> value, Integer::sum));
        System.out.println(map);
    }

    //Create a stream of lists of integers and use map to find the sum of each list.
    void transformToListOfSums() {
        List<List<Integer>> listOfLists = List.of(List.of(22, 7, 5, 5), List.of(4, 3, 3), List.of(2), List.of(2, 2, 1, 1, 1, 1, 1));
        List<Integer> result = listOfLists.stream()
                .map(v -> v.stream().mapToInt(Integer::intValue).sum()).toList();
        System.out.println(result);
    }

    //collect list of lists to map: key = first element, value = sum
    void transformToMapOfSums() {
        List<List<Integer>> listOfLists = List.of(List.of(22, 7, 5, 5), List.of(4, 3, 3), List.of(2), List.of(2, 2, 1, 1, 1, 1, 1));
        Map<Integer, Integer> result = listOfLists.stream()
                .collect(Collectors.toMap(
                        element -> element.get(0),
                        element -> element.stream().mapToInt(Integer::intValue).sum(),
                        (one, two) -> one < two ? one : two
                ));
        System.out.println(result);
    }

    //Use map to transform a stream of objects into another stream of objects with specific properties modified.


    @Test
    void test() {
        multiplyBy2();
        toUppercase();
        parseToInt();
        toChars();
        roundToInt();
        countLengthsToMap();
        countLengthsToMapWithIndexAsKey();
        transformToLengths();
        transformToMapOfCharString();
        transformToMapOfIntCounter();
        transformToMapOfIntSumOfValues();
        transformToListOfSums();
        transformToMapOfSums();
    }
}
