package com.leetcode.midium;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland695 {
    public static void main(String[] args) {
        maxAreaOfIsland(new int[][]{
                {1, 1}, {1, 1}
        });
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int height = 0;
    static int width = 0;

    static int result = 0;
//    static boolean[][] isVisited = new boolean[height][width];

    public static int maxAreaOfIsland(int[][] grid) {

        height = grid.length;
        width = grid[0].length;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                if (grid[i][j] == 1) {
                    result = Math.max(result, dfs(i, j, grid));
                }

            }
        }
        return result;
    }

    public static int dfs(int x, int y, int[][] grid) {

        if (x < 0 || height <= x || y < 0 || width <= y) {
            return 0;
        }
        if (grid[x][y] == 0) {
            return 0;
        }
        grid[x][y] = 0;
        int area = 1;
        area += dfs(x + 1, y, grid) +
                dfs(x - 1, y, grid) +
                dfs(x, y + 1, grid) +
                dfs(x, y - 1, grid);

        return area;
    }
}
