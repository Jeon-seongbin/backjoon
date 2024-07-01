package com.leetcode.easy;

public class ThreeConsecutiveOdds1550 {
    public static void main(String[] args) {
        threeConsecutiveOdds(new int[]{1, 2, 3, 4, 5, 6});
    }

    public static boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 0; i < arr.length - 2; i++) {
            boolean isOdd = true;
            for (int j = i; j < i + 3; j++) {
                if (arr[j] % 2 == 0) {
                    isOdd = false;
                    break;
                }
            }
            if (isOdd) {
                return isOdd;
            }
        }
        return false;
    }
}
