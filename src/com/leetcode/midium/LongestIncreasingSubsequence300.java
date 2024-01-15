package com.leetcode.midium;

import java.util.Arrays;
import java.util.HashSet;

public class LongestIncreasingSubsequence300 {
    public static void main(String[] args) {
        lengthOfLIS(new int []{0,1,0,3,2,3});
    }

    public static int lengthOfLIS(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for(int n : nums){
            set.add(n);
        }
        if(set.size() == 1){
            return 1;
        }
        int temp = nums[0];

        int result = 1;
        for (int i = 1; i < nums.length; i++) {

            if (temp <= nums[i]) {
                result++;
                temp = nums[i];
            }

        }

        return result;
    }
}
