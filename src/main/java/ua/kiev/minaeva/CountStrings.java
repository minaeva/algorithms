package ua.kiev.minaeva;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountStrings {


    public Map<String, Integer> count(String input) {
        List<String> words = Arrays.asList(input.split(" "));
        Map<String, Integer> result = words
                .stream()
//               Function.identity() is the same as word -> word
                .collect(Collectors.toMap(Function.identity(), word -> 1, Integer::sum));
        System.out.println(result);
        return result;
    }


    public Map<String, Integer> countInParallel(String input)
    {
        List<String> words = Arrays.asList(input.split(" "));
        Map<String, Integer> result = words.parallelStream().
                collect(Collectors.toMap(
                        word -> word, word -> 1, Integer::sum));
        System.out.println(result);
        return result;
    }
}
