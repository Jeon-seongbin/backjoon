package com.leetcode.midium;

public class PathWithMaximumGold1219 {
    public static void main(String[] args) {
    }

    int[] dx = new int[]{1, 0, -1, 0};
    int[] dy = new int[]{0, 1, 0, -1};
    int result = 0;

    public int getMaximumGold(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] != 0) {
                    result = Math.max(result, dfs(grid, i, j, height, width));
                }
            }
        }
        return result;
    }

    public int dfs(int[][] grid, int i, int j, int height, int width) {
        if (i < 0 || height <= i || j < 0 || width <= j || grid[i][j] == 0) {
            return 0;
        }

        int curr = grid[i][j];
        grid[i][j] = 0;
        int localResult = curr;
        for (int z = 0; z < 4; z++) {
            int newX = i + dx[z];
            int newY = j + dy[z];
            localResult = Math.max(localResult, curr + dfs(grid, newX, newY, height, width));
        }

        grid[i][j] = curr;
        return localResult;
    }
}
