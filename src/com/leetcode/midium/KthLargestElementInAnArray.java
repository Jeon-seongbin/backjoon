package com.leetcode.midium;

import java.util.Arrays;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {

    }
    public int findKthLargest(int[] nums, int k) {

        Arrays.sort(nums);

        return nums[nums.length - 1 - k];
    }

}
