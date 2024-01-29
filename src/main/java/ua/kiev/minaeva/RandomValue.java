package ua.kiev.minaeva;

//Given an array of N Strings, write a program which allows to draw each value from the array with certain probability.
//For example, array is: {"A", "B", "C"}
//Need to draw values:
//Value Weight
//“A” 3
//“B” 5
//“C” 2
//
//
//Please use Java Random class and its nextInt(int n) method
// which returns integers in range from 0 (inclusive) to n (exclusive).
//

//[3, 5, 2]
//[A, A, A, B, B, B, B, B, C, C]

import org.junit.jupiter.api.Test;

import java.util.Random;

public class RandomValue {

    String getRandomValue(String[] values, int[] weights) {
        int totalWeight = 0;
        for (int weight : weights) {
            totalWeight += weight;
        }

        Random random = new Random();
        int randomInt = random.nextInt(totalWeight);

        System.out.println(randomInt);
        int currentWeight = 0;
        for (int i = 0; i < weights.length; i++) {
            currentWeight += weights[i];
            if (randomInt < currentWeight) {
                return values[i];
            }
        }
        return null;
    }

    @Test
    public void getRandomValue_when9() {
        String result = getRandomValue(new String[]{"A", "B", "C"}, new int[]{3, 5, 2});
        System.out.println(result);
    }
}
