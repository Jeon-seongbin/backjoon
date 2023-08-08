package com.leetcode.midium;

import java.util.HashMap;

public class SearchInRotatedSortedArray33 {
    public static void main(String[] args) {
    }

    public int search(int[] nums, int target) {
        int startIndex = 0;
        int endIndex = nums.length - 1;

        while (startIndex <= endIndex) {
            int midIndex = (endIndex + startIndex) / 2;

            if (nums[midIndex] == target) {
                return midIndex;
            }

            if (nums[startIndex] <= nums[midIndex]) {
                if (nums[startIndex] <= target && target < nums[midIndex]) {
                    endIndex = midIndex - 1;
                } else {
                    startIndex = midIndex + 1;
                }
            } else {
                if (nums[midIndex] < target && target <= nums[endIndex]) {
                    startIndex = midIndex + 1;
                } else {
                    endIndex = midIndex - 1;
                }
            }

        }
        return -1;
    }

    public int search1(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }
        if (hashMap.containsKey(target)) {
            return hashMap.get(target);
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

}
