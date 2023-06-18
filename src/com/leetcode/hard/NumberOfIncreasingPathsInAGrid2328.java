package com.leetcode.hard;

import java.util.Arrays;


public class NumberOfIncreasingPathsInAGrid2328 {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1},
                {3, 4}
        };
        NumberOfIncreasingPathsInAGrid2328 test = new NumberOfIncreasingPathsInAGrid2328();

        int result = test.countPaths(grid);

        System.out.println(result);
    }

    int mod = (int) (1e9 + 7);

    public int countPaths(int[][] grid) {


        int x = grid.length;
        int y = grid[0].length;
        int[][] dp = new int[x][y];
        int path = 0;

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                path = (path + solve(grid, i, j, -1, dp)) % mod;
            }
        }
        return path;
    }

    public int solve(int[][] grid, int nowX, int nowY, int prev, int[][] dp) {
        if (nowX < 0 || grid.length <= nowX || nowY < 0 || grid[0].length <= nowY || grid[nowX][nowY] <= prev) {
            return 0;
        }

        if (dp[nowX][nowY] != -1) {
            return dp[nowX][nowY];
        }
        int left = solve(grid, nowX, nowY - 1, grid[nowX][nowY], dp);
        int right = solve(grid, nowX, nowY + 1, grid[nowX][nowY], dp);
        int up = solve(grid, nowX - 1, nowY, grid[nowX][nowY], dp);
        int bottom = solve(grid, nowX + 1, nowY, grid[nowX][nowY], dp);

        return dp[nowX][nowY] = (1 + left + right + up + bottom) % mod;


    }


}
