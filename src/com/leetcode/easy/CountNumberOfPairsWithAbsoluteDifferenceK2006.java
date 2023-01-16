package com.leetcode.easy;

public class CountNumberOfPairsWithAbsoluteDifferenceK2006 {
    public static void main(String[] args) {

    }

    public static int countKDifference(int[] nums, int k) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {
                if(k == Math.abs(nums[i] - nums[j])){
                    result++;
                }
            }
        }

        return result;
    }
}
