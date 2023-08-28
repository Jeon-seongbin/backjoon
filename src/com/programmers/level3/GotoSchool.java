package com.programmers.level3;

public class GotoSchool {
    public static void main(String[] args) {
        solution(4, 3, new int[][]{
//                {2, 1},
//                {1, 2},

                {2, 2}
        });
    }

    public static int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];

        for (int[] puddle : puddles) {
            dp[puddle[1] - 1][puddle[0] - 1] = -1;
        }

        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j] == 0) {
                    if (i != 0 && dp[i - 1][j] != -1) {
                        dp[i][j] += dp[i - 1][j];
                    }
                    if (j != 0 && dp[i][j - 1] != -1) {
                        dp[i][j] += dp[i][j - 1];
                    }
                    dp[i][j] %= 1000000007;
                }
            }
        }
        return dp[n - 1][m - 1];

    }

    public static int solution1(int m, int n, int[][] puddles) {
        // dp 선언
        int[][] dp = new int[n][m];

        // 물 웅덩이는 못간다고 표시
        for (int[] puddle : puddles) {
            dp[puddle[1] - 1][puddle[0] - 1] = Integer.MIN_VALUE;
        }


        boolean cantGo = false;

        // 세로 첫번째 줄을 1로 표시
        // 그렇지만 못가는경우가 있을경우 못가는곳 이후로는 못간다고 표시(Integer.MIN_VALUE)
        for (int i = 0; i < n; i++) {
            if (cantGo) {
                dp[i][0] = Integer.MIN_VALUE;
                continue;
            }

            if (dp[i][0] != Integer.MIN_VALUE) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = Integer.MIN_VALUE;
                cantGo = true;
            }
        }

        cantGo = false;

        // 가로 첫번째 줄을 1로 표시
        // 그렇지만 못가는경우가 있을경우 못가는곳 이후로는 못간다고 표시(Integer.MIN_VALUE)
        for (int i = 0; i < m; i++) {
            if (cantGo) {
                dp[0][i] = Integer.MIN_VALUE;
                continue;
            }

            if (dp[0][i] != Integer.MIN_VALUE) {
                dp[0][i] = 1;

            } else {
                dp[0][i] = Integer.MIN_VALUE;
                cantGo = true;
            }
        }


        // 첫번째 줄 이외에 물 웅덩이가 있을 시
        for (int[] puddle : puddles) {
            dp[puddle[1] - 1][puddle[0] - 1] = Integer.MIN_VALUE;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (dp[i][j] == Integer.MIN_VALUE) {
                    continue;
                }


                int a = dp[i][j - 1];
                if (dp[i][j - 1] == Integer.MIN_VALUE) {
                    a = 0;
                }

                int b = dp[i - 1][j];
                if (dp[i - 1][j] == Integer.MIN_VALUE) {
                    b = 0;
                }

                dp[i][j] = (a + b) % 1_000_000_007;

            }
        }

        return dp[n - 1][m - 1];
    }
}
