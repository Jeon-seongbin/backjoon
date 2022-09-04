package com.leetcode.midium;

import java.util.*;

public class Sum3_15 {
    public static void main(String[] args) {
        threeSum(new int[]{1, 2, 3});
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> result = new HashSet<>();

        if (nums == null || nums.length < 3)
            return new ArrayList<>(result);
        Arrays.sort(nums);

        int size = nums.length;
        for (int i = 0; i < size - 2; i++) {
            int start = i + 1;
            int end = size - 1;

            while (start < end) {
                int temp = nums[i] + nums[start] + nums[end];
                if (temp > 0) {
                    end--;
                } else if (temp < 0) {
                    start++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                    end--;
                }
            }
        }

        return new ArrayList<>(result);
    }
}
