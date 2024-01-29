package ua.kiev.minaeva;
//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//Example:
//Given nums = [2, 1, 7, 11, 15], target = 9
//
//
//Because nums[0] + nums[2] = 2 + 7 = 9,
//return [0, 2]

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FindSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException();
    }

    @Test
    public void twoSum_gets9() {
        int[] result = twoSum(new int[]{2, 1, 7, 11, 15}, 9);
        assertEquals(result[0], 2);
        assertEquals(result[1], 0);
    }

    @Test
    public void twoSum_when4_thenThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> twoSum(new int[]{2, 1, 7, 11, 15}, 4));
    }
}
