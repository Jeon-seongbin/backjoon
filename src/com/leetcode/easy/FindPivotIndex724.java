package com.leetcode.easy;

public class FindPivotIndex724 {
    public static void main(String[] args) {

    }

    public int pivotIndex(int[] nums) {
        boolean isSame = false;
        int i = 0;
        for (; i < nums.length; i++) {
            int leftSum = 0;
            for (int left = 0; left < i; left++) {
                leftSum += nums[left];
            }
            int rightSum = 0;

            for (int right = i + 1; right < nums.length; right++) {
                rightSum += nums[right];
            }

            if (leftSum == rightSum) {
                isSame = true;
                break;
            }
        }

        if (isSame) {
            return i;
        }
        return -1;
    }

}
