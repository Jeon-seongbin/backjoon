package com.programmers.level3;

public class TaxiGetTogether {
    public static void main(String[] args) {

    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;

        int[][] dp = new int[n + 1][n + 1];
        int max = 20000001;

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == j) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = max;
            }
        }

        for (int i = 0; i < fares.length; i++) {
            int start = fares[i][0];
            int end = fares[i][1];
            int cost = fares[i][2];
            dp[start][end] = cost;
            dp[end][start] = cost;
        }

        for (int z = 0; z < n + 1; z++) {
            for (int i = 0; i < n + 1; i++) {
                for (int j = 0; j < n + 1; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][z] + dp[z][j]);
                }
            }
        }


        answer = dp[s][a] + dp[s][b];

        for (int i = 0; i < n + 1; i++) {
            answer = Math.min(answer, dp[s][i] + dp[i][a] + dp[i][b]);
        }

        return answer;
    }
}
