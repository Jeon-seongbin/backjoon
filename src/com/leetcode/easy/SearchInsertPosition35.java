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
        int pivot = 0;
        while (left <= right) {
            pivot = right - left / 2;

            if (nums[pivot] == target) {
                return pivot;
            }

            if (target < nums[pivot]) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        if (nums[pivot] < target) {
            pivot++;
        }
        return pivot;
    }
}
