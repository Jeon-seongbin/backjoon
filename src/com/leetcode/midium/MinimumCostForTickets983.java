package com.leetcode.midium;

import java.util.Arrays;

public class MinimumCostForTickets983 {
    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};

        mincostTickets(days, costs);
    }

    public static int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366];
        int n = days.length;
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int j = 0;

        for (int i = 1; i <= 365; i++) {
            if (j < n && i == days[j]) {
                dp[i] = Math.min(dp[i], dp[i - 1] + costs[0]);

                if (i >= 7) {
                    dp[i] = Math.min(dp[i], dp[i - 7] + costs[1]);
                } else {
                    dp[i] = Math.min(dp[i], costs[1]);
                }

                if (i >= 30) {
                    dp[i] = Math.min(dp[i], dp[i - 30] + costs[2]);
                } else {
                    dp[i] = Math.min(dp[i], costs[2]);
                }

                j++;
            } else {
                dp[i] = dp[i - 1];
            }

        }
        return dp[365];
    }
}
