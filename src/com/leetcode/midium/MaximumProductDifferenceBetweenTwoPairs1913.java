package com.leetcode.midium;

import java.util.Arrays;

public class MaximumProductDifferenceBetweenTwoPairs1913 {
    public static void main(String[] args) {

    }

    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int min = nums[0] * nums[1];
        int max = nums[nums.length - 1] * nums[nums.length - 2];

        return max - min;
    }
}
