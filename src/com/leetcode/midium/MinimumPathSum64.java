package com.leetcode.midium;

public class MinimumPathSum64 {
    public static void main(String[] args) {
        int[][] dp = new int[2][3];
        dp[0][0] = 1;
        dp[0][1] = 2;
        dp[0][2] = 3;

        dp[1][0] = 4;
        dp[1][1] = 5;
        dp[1][2] = 6;

        System.out.println(minPathSum(dp));
    }

    public static int minPathSum(int[][] grid) {

        int width = grid[0].length;
        int height = grid.length;
        int[][] dp = new int[height][width];

        int sum = 0;
        for (int i = 0; i < height; i++) {
            dp[i][0] = sum + grid[i][0];
            sum += grid[i][0];
        }
        sum = 0;
        for (int i = 0; i < width; i++) {
            dp[0][i] = sum + grid[0][i];
            sum += grid[0][i];
        }

        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                int yo = grid[i][j] + dp[i][j - 1];
                int ue = grid[i][j] + dp[i - 1][j];

                dp[i][j] = Math.min(yo, ue);
            }
        }

        return dp[height - 1][width - 1];
    }

    public static int minPathSum1(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;

        for (int i = 1; i < width; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for (int i = 1; i < height; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                int a = grid[i][j] + grid[i - 1][j];
                int b = grid[i][j] + grid[i][j - 1];
                grid[i][j] = Math.min(a, b);
            }
        }

        return grid[height - 1][width - 1];
    }
}
