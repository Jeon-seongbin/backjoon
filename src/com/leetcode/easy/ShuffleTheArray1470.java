package com.leetcode.easy;

public class ShuffleTheArray1470 {
    public static void main(String[] args) {

    }

    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                result[i] = nums[start];
                start++;
            } else {
                result[i] = nums[n];
                n++;
            }
        }
        return result;
    }
}
