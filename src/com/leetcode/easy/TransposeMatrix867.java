package com.leetcode.easy;

public class TransposeMatrix867 {
    public static void main(String[] args) {
        transpose(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
        });
    }

    public static int[][] transpose(int[][] matrix) {
        int width = matrix[0].length;
        int height = matrix.length;

        int[][] result = new int[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                result[i][j] = matrix[j][i];
            }

        }

        return result;
    }
}
