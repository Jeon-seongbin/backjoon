package com.leetcode.midium;

public class UniquePathsII63 {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int height = obstacleGrid.length;
        int width = obstacleGrid[0].length;
        int[][] dp = new int[height][width];

        for (int i = 0; i < height; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }

        for (int i = 0; i < width; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            dp[0][i] = 1;
        }

        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }

                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[height - 1][width - 1];
    }

    public static void main(String[] args) {
        uniquePathsWithObstacles(new int[][]{{0}});
    }

    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {

        int width = obstacleGrid[0].length;
        int height = obstacleGrid.length;
        int[][] map = new int[height][width];


        for (int i = 0; i < height; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            map[i][0] = 1;
        }

        for (int i = 0; i < width; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            map[0][i] = 1;
        }


        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {

                if (obstacleGrid[i][j] == 1) {
                    map[i][j] = 0;
                    continue;
                }

                map[i][j] = map[i - 1][j] + map[i][j - 1];

            }
        }
        return map[height - 1][width - 1];
    }
}
