package com.leetcode.midium;

public class SearchA2DMatrixII240 {
    public static void main(String[] args) {
        int[][] input = new int[5][5];

        input[0][0] = 1;
        input[0][1] = 4;
        input[0][2] = 7;
        input[0][3] = 11;
        input[0][4] = 15;

        input[1][0] = 2;
        input[1][1] = 5;
        input[1][2] = 8;
        input[1][3] = 12;
        input[1][4] = 19;

        input[2][0] = 3;
        input[2][1] = 6;
        input[2][2] = 9;
        input[2][3] = 16;
        input[2][4] = 22;

        input[3][0] = 10;
        input[3][1] = 13;
        input[3][2] = 14;
        input[3][3] = 17;
        input[3][4] = 24;

        input[4][0] = 18;
        input[4][1] = 21;
        input[4][2] = 23;
        input[4][3] = 26;
        input[4][4] = 30;

//        [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]


        System.out.println(searchMatrix(input, 5));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        boolean result = false;

        int height = matrix.length;
        int width = matrix[0].length;

        for (int i = 0; i < matrix.length; i++) {

            int low = 0;
            int high = width - 1;

            while (low <= high) {
                int mid = (low + high) / 2;
                if (matrix[i][mid] < target) {
                    low = mid + 1;
                } else if (target < matrix[i][mid]) {
                    high = mid - 1;
                } else {
                    result = true;
                    break;
                }
            }

            if (result) {
                return true;
            }
        }


        return false;
    }
}
