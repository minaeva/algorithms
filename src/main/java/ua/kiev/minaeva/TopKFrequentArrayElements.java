package ua.kiev.minaeva;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

//Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
public class TopKFrequentArrayElements {

    public int[] topKFrequent(int[] nums, int k) {
        if (k > nums.length) {
            return new int[]{};
        }

        Map<Integer, Integer> pairs = new HashMap<>();
        for (int element : nums) {
            int prevCount = 0;
            if (pairs.containsKey(element)) {
                prevCount = pairs.get(element);
            }
            pairs.put(element, ++prevCount);
        }
        //{"1,3", "2,4", "3,2", "5,1"}

        Map<Integer, Integer> sortedByValues = pairs.entrySet()
                .stream()
                .limit(k)
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        sortedByValues.forEach((key, v) -> System.out.println(key + ": " + v));
        //{"2,4", "1,3", "3,2", "5,1"}
        //after limit 2
        //{"2,4", "1,3"}

        List<Integer> list = sortedByValues.keySet().stream()
                .toList();
        return list.stream().mapToInt(Integer::intValue).toArray();
    }


    public int[] topKFrequentPriorityQueue(int[] nums, int k) {

        if (k > nums.length) {
            return new int[]{};
        }
        Map<Integer, Integer> pairs = new HashMap<>();
        for (int num : nums) {
            pairs.put(num, pairs.getOrDefault(num, 0) + 1);
        }
        //a queue of keys in the order of their values increasing
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((key1, key2) -> pairs.get(key1) - pairs.get(key2));

        for (int n : pairs.keySet()) {
            priorityQueue.add(n);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        int[] result = new int[k];
        while (!priorityQueue.isEmpty()) {
            for (int i = 0; i < k; i++)
                result[i] = priorityQueue.poll();
        }

        return result;
    }


    //Input: nums = [1,1,1,2,2,3], k = 2
    // Output: [1,2]
    @Test
    public void topKFrequent_example1() {
        int[] input = new int[]{1, 1, 1, 2, 2, 2, 2, 3, 3, 5};
        int k = 2;
        int[] result = topKFrequent(input, k);

        assertThat(result).isEqualTo(new int[]{2, 1});
    }

    //Input: nums = [1], k = 1
    //Output: [1]

    @Test
    public void topKFrequent_example2() {
        int[] input = new int[]{1};
        int k = 1;
        int[] result = topKFrequent(input, k);

        assertThat(result).isEqualTo(new int[]{1});
    }

    @Test
    public void topKFrequentPriorityQueue_example1() {
        int[] input = new int[]{8, 8, 4, 8, 4, 9, 9, 9, 5, 8, 7};
        int k = 2;
        int[] result = topKFrequentPriorityQueue(input, k);

        assertThat(result).isEqualTo(new int[]{9, 8});
    }

    @Test
    public void topKFrequentPriorityQueue_example2() {
        int[] input = new int[]{1};
        int k = 1;
        int[] result = topKFrequentPriorityQueue(input, k);

        assertThat(result).isEqualTo(new int[]{1});
    }


}



