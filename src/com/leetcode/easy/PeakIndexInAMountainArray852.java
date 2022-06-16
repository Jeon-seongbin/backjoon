package com.leetcode.easy;

public class PeakIndexInAMountainArray852 {
    public static void main(String[] args) {
        peakIndexInMountainArray(new int[]{0, 1, 0});
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int a = Integer.MIN_VALUE;
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (a < arr[i]) {
                result = i;
                a = arr[i];
            }
        }
        return result;
    }
}
