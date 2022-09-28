package com.leetcode.midium;

import java.util.Arrays;

public class CoinChange322 {
    public static void main(String[] args) {

      System.out.println(  coinChange(new int[]{2, 5}, 11));
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, 100001);
        dp[0] = 0;

        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (0 <= j - coins[i]) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                    System.out.println(j);
                    System.out.println(dp[j]);

                }
            }
        }
        return dp[amount] == 10001 ? -1 : dp[amount];
    }
}
