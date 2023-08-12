package com.programmers.level3;

public class MoneyChange {
    public static void main(String[] args) {
        solution(5, new int[]{1, 2, 5});
    }

    public static int solution(int n, int[] money) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int m : money) {
            for (int i = m; i < n + 1; i++) {
                dp[i] += dp[i - m];
            }

        }

        return dp[dp.length - 1];
    }
}
