package com.leetcode.midium;


public class MinimumSizeSubarraySum209 {
    public static void main(String[] args) {

    }

    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;

        while (start < nums.length) {
            sum += nums[start++];
            while (target <= sum) {
                result = Math.min(start - end, result);
                sum -= nums[end++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
