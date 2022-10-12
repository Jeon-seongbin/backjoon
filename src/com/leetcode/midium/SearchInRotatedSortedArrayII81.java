package com.leetcode.midium;

import java.util.Arrays;

public class SearchInRotatedSortedArrayII81 {
    public static void main(String[] args) {

    }

    public static boolean search(int[] nums, int target) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        int pivot = 0;
        while (start <= end) {
            pivot = (end - start) / 2;
            if (nums[pivot] == target) {
                return true;
            }
            if (nums[pivot] < target) {
                start = pivot + 1;
            } else {
                end = pivot - 1;
            }
        }

        return false;
    }
}
