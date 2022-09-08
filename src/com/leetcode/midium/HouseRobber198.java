package com.leetcode.midium;

public class HouseRobber198 {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1}));
    }

    public static int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = dp[i - 1] + nums[i];
            dp[i + 1] = Math.max(temp, dp[i]);
        }
        return dp[nums.length];
    }
}
