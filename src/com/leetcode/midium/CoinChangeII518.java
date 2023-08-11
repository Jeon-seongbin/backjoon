package com.leetcode.midium;

public class CoinChangeII518 {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{2, 5}, 11));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }
}
