package com.leetcode.easy;

public class FindTheDistanceValueBetweenTwoArrays1385 {
    public static void main(String[] args) {
//[2,1,100,3]
//[-5,-2,10,-3,7]
//        6
        findTheDistanceValue(new int[]{2, 1, 100, 3}, new int[]{-5, -2, 10, -3, 7}, 6);
    }

    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int result = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                int aa = Math.abs(arr1[i] - arr2[j]);
                int bb = Math.abs(arr2[j] - arr1[i]);
//                if (aa == 0 || bb == 0) {
//                    continue;
//                }
                if ( 0 <= arr1[i] - arr2[j] && arr1[i] - arr2[j] <= d) {

                        result++;


                }
            }
        }
        return result;
    }
}
