package com.leetcode.easy;

public class NumberOfGoodPairs1512 {
    public static void main(String[] args) {
        numIdenticalPairs(new int[]{1, 1, 1, 1});
    }


    public static int numIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = backtracking(i, nums, 1, count);

        }


        return count;
    }

    public static int backtracking(int nowindex, int[] nums, int nowCount, int count) {

        if (nowCount == 2) {
            return count;
        }

        for (int i = nowindex + 1; i < nums.length; i++) {
            if (nums[nowindex] == nums[i]) {
                count++;
            }
            count = backtracking(i, nums, nowCount + 1, count);
        }

        return count;

    }
}
