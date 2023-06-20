package com.leetcode.midium;

import java.util.Arrays;

public class KRadiusSubarrayAverages2090 {
    public static void main(String[] args) {
        getAverages(new int[]{7, 4, 3, 9, 1, 8, 5, 2, 6}, 3);
    }

    public static int[] getAverages(int[] nums, int k) {

        int[] result = new int[nums.length];
        Arrays.fill(result, -1);


        int windowSize = 2 * k + 1;
        if (nums.length < windowSize) {
            return result;
        }

        long[] prefixSum = new long[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }


        for (int i = k; i + k < nums.length; i++) {
            result[i] = (int) ((prefixSum[i + k + 1] - prefixSum[i - k]) / windowSize);
        }
        return result;

    }
}
