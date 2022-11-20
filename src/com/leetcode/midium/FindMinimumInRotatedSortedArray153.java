package com.leetcode.midium;

import java.util.Arrays;

public class FindMinimumInRotatedSortedArray153 {
    public static void main(String[] args) {
    }

    public static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return nums[start];
    }

    public static int findMin2(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }

    public int findMin3(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < min)
                min = num;
        }
        return min;
    }
}
