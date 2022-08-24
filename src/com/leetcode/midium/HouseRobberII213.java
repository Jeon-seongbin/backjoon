package com.leetcode.midium;

public class HouseRobberII213 {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 3, 2}));
    }

    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        int[] dp2 = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = nums[0];

        dp2[0] = 0;
        dp2[1] = nums[1];


        int result = 0;
        for (int i = 2; i < nums.length; i++) {

            if (i != nums.length - 1) {
                dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
            }
            dp2[i] = Math.max(dp2[i - 1], nums[i] + dp2[i - 2]);

        }
        return Math.max(dp[nums.length - 2], dp2[nums.length - 1]);
    }
}
