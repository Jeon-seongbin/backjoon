package com.leetcode.midium;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray34 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{2, 2}, 3)));
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        boolean isFind = false;
        int start = 0;
        int end = nums.length;
        int pivot = 0;
        while (start <= end) {
            pivot = start + (end - start) / 2;
            if (nums.length <= pivot) {
                break;
            }
            if (nums[pivot] == target) {
                isFind = true;
                break;
            }
            if (nums[pivot] < target) {
                start = pivot + 1;
            } else {
                end = pivot - 1;
            }
        }

        if (!isFind) {
            return new int[]{-1, -1};
        }
        int startIndex = pivot;
        int endIndex = pivot;
        for (int i = pivot; i >= 0; i--) {
            if (nums[pivot] == nums[i]) {
                startIndex = i;
            }
        }

        for (int i = pivot; i < nums.length; i++) {
            if (nums[pivot] == nums[i]) {
                endIndex = i;
            }
        }

        return new int[]{startIndex, endIndex};


    }
}
