package com.leetcode.midium;

public class MaximumSubarray53 {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public static int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(currentSum + nums[i], nums[i]);
            max = Math.max(currentSum, max);
        }
        return max;
    }
}
