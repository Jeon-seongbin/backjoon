package com.leetcode.midium;

public class WhereWillTheBallFall1706 {
    public static void main(String[] args) {

    }

    public static int colSize = 0;

    public static int[] findBall(int[][] grid) {
        colSize = grid[0].length;
        int[] result = new int[colSize];
        for (int i = 0; i < colSize; i++) {
            result[i] = dfs(grid, 0, i);
        }
        return result;
    }

    public static int dfs(int[][] grid, int row, int col) {

        // stuck in wall
        // return -1;
        if (col < 0 || colSize <= col) {
            return -1;
        }

        // reach final goal
        // return col
        if (row == grid.length) {
            return col;
        }

        // check v Pattern
        // if v pattern return -1;
        if (grid[row][col] == 1) {
            if (col < colSize - 1 && grid[row][col] != grid[row][col + 1]) {
                return -1;
            }
        } else {

            if (0 < col && grid[row][col - 1] != grid[row][col]) {
                return -1;
            }
        }

        // calculate col
        col += grid[row][col];
        return dfs(grid, row + 1, col);
    }
}
