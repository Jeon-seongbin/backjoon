package com.leetcode.easy;

public class SpecialPositionsInABinaryMatrix1582 {
    public static void main(String[] args) {

    }

    public int numSpecial(int[][] mat) {
        int[] colMat = new int[mat[0].length];
        int[] rowMat = new int[mat.length];


        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    rowMat[i]++;
                    colMat[j]++;
                }
            }
        }


        int result = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    if( rowMat[i]== 1&& colMat[j] == 1){
                        result++;
                    }
                }
            }
        }
        return result;
    }

}
