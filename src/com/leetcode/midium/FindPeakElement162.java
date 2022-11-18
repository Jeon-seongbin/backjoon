package com.leetcode.midium;

public class FindPeakElement162 {
    public int findPeakElement(int[] nums) {
        int check = Integer.MIN_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (check <= nums[i]) {
                result = i;
                check = nums[i];
            }
        }
        return result;
    }
}
