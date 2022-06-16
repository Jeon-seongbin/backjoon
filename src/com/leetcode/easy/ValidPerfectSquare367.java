package com.leetcode.easy;

public class ValidPerfectSquare367 {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare1(9));
    }

    public static boolean isPerfectSquare(int num) {
        long start = 1;
        long end = num;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (num == mid * mid) {
                return true;
            } else if (mid * mid < num) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    public static boolean isPerfectSquare1(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }
}
