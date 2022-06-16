package com.leetcode.easy;

public class SearchInsertPosition35 {
    public static int pivot = 0;

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        searchInsert(nums, target);
        System.out.println(pivot);
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (pivot == target) {
                return pivot;
            }
            if (nums[pivot] < target) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        if (nums[pivot] < target) {
            pivot++;
        }
        return pivot;
    }
}
