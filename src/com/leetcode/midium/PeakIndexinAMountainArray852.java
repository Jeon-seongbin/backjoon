package com.leetcode.midium;

public class PeakIndexinAMountainArray852 {
    public static void main(String[] args) {
        int a = peakIndexInMountainArray1(new int[]{0, 1, 0});
        int b = peakIndexInMountainArray2(new int[]{0, 1, 0});
        System.out.println(a);
        System.out.println(b);

    }

    public static int peakIndexInMountainArray1(int[] arr) {
        int before = 0;
        for (int i = 0; i < arr.length; i++) {
            if (before <= arr[i]) {
                before = arr[i];
                continue;
            }
            return i - 1;

        }
        return before;
    }


    public static int peakIndexInMountainArray2(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
