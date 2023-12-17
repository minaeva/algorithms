package ua.kiev.minaeva;

public class MaxSubarraySum {

    public int findMaxSubarraySum(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array is empty or null");
        }

        int maxSubarraySum = nums[0];
        int currentSubarraySum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSubarraySum = Math.max(currentSubarraySum + nums[i], nums[i]);
            maxSubarraySum = Math.max(maxSubarraySum, currentSubarraySum);
        }
        return maxSubarraySum;
    }

 }
