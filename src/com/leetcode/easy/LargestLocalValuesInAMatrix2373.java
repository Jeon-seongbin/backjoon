package com.leetcode.easy;

public class LargestLocalValuesInAMatrix2373 {
    public static void main(String[] args) {

        int[][] grid = {

//                {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 2, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}
                {2,5,5},{3,2,5},{1,2,3}
        };
        System.out.println(largestLocal(grid));
    }

    public static int[][] largestLocal(int[][] grid) {

        int newRowSize = grid.length - 2;
        int newColSize = grid[0].length - 2;

        int[][] resultGrid = new int[newRowSize][newColSize];

        for (int i = 0; i <= grid.length - newRowSize; i++) {
            for (int j = 0; j <= grid[0].length - newColSize; j++) {

                for (int ii = 0; ii < newRowSize; ii++) {

                    for (int jj = 0; jj < newColSize; jj++) {


                        resultGrid[ii][jj] = Math.max(resultGrid[ii][jj], grid[i + ii][j + jj]);
                    }
                }

            }
        }

        return resultGrid;

    }
}
