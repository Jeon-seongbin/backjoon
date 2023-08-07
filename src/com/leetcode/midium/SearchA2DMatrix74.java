package com.leetcode.midium;

import java.util.Arrays;

public class SearchA2DMatrix74 {
    public static void main(String[] args) {
        searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int[] m : matrix) {
            Arrays.sort(m);

            int leftIndex = 0;
            int rightIndex = m.length - 1;

            while (leftIndex <= rightIndex) {
                int mid = (leftIndex + rightIndex) / 2;
                if (mid == target) {
                    return true;
                }

                if (mid < target) {
                    leftIndex = mid + 1;
                } else {
                    rightIndex = mid - 1;
                }
            }
        }
        return false;
    }
}
