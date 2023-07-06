package com.leetcode.midium;

public class MinimumSizeSubarraySum209_1 {
    public static void main(String[] args) {
        minSubArrayLen(1, new int[]{1, 4, 4});
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int length = Integer.MAX_VALUE;


        while (right < nums.length) {
            sum += nums[right++];
            while (target <= sum) {
                length = Math.min(right - left, length);
                sum -= nums[left++];
            }
        }
        return length == Integer.MAX_VALUE ? 0 : length;
    }
}
