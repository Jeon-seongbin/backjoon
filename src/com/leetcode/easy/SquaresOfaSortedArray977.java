package com.leetcode.easy;

import java.util.Arrays;

public class SquaresOfaSortedArray977 {
    public static void main(String[] args) {

    }

    public int[] sortedSquares(int[] nums) {
        nums = Arrays.stream(nums)
                .map(obj -> Math.abs(obj * obj))
                .toArray();
//        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }
}
