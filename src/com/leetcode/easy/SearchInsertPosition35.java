package com.leetcode.easy;

public class SearchInsertPosition35 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 9;
        int result = searchInsert(nums, target);
        System.out.println(result);
    }

    public static int searchInsert(int[] nums, int target) {

        if (nums[nums.length - 1] < target) {
            return nums.length;
        }

        int low = 0;
        int high = nums.length - 1;
        int result = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                result = mid;
                break;
            }
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
                result = high;

            }
        }
        return result;
    }
}
