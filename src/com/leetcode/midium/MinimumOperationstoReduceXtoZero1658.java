package com.leetcode.midium;

import java.util.Arrays;

public class MinimumOperationstoReduceXtoZero1658 {
    public static void main(String[] args) {

    }

    public int minOperations(int[] nums, int x) {
        int length = nums.length;
        int totalSum = Arrays.stream(nums).sum();

        int target = totalSum - x;
        if (target == 0) return length;
        if (target < 0) return -1;

        int left = 0;
        int left2 = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        while (left < length) {
            sum += nums[left];

            while (target < sum) {
                sum -= nums[left2];
                left2++;
            }

            if (sum == target) {
                min = Math.min(min, length - (left - left2 + 1));
            }

            left++;
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

}
