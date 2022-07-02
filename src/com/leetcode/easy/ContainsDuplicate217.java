package com.leetcode.easy;

import java.util.Arrays;

public class ContainsDuplicate217 {
    public boolean containsDuplicate(int[] nums) {

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] == nums[j]) {
                    return true;
                } else {
                    break;
                }
            }
        }
        return false;
    }
}
