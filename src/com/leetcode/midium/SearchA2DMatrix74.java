package com.leetcode.midium;

public class SearchA2DMatrix74 {
    public static void main(String[] args) {
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        int height = matrix.length;

        int width = matrix[0].length;

        for (int i = 0; i < height; i++) {
            int low = 0;
            int high = width - 1;


            while (low <= high) {

                int mid = (low + high) / 2;

                if (matrix[i][mid] < target) {
                    low = mid + 1;

                } else if (target < matrix[i][mid]) {
                    high = mid - 1;
                } else {
                    return true;
                }

            }
        }
        return false;
    }

}
