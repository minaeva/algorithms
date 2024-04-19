package ua.kiev.minaeva.ocp.streams;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class RomanNumeralConverter {

    private static final Map<Integer, String> romanNumerals = Map.of(
            1, "I", 2, "II", 3, "III", 4, "IV", 5, "V", 6, "VI"
    );

    private static String intToRoman(Integer key) {
        return romanNumerals.get(key);
    }


    @Test
    void test() {
        List<Integer> input = List.of(3, 5, 2, 1, 6);
        List<String> result = input.stream().map(RomanNumeralConverter::intToRoman).toList();
        System.out.println(result);
    }
}


