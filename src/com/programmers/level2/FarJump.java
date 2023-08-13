package com.programmers.level2;

public class FarJump {
    public static void main(String[] args) {
        solution(4);
    }
    
    public static long solution(int n) {
        long[] dp = new long[2001];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i < n + 1; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }

        return dp[n];
    }
}
