package com.leetcode.easy;

public class UglyNumber263 {
    public static void main(String[] args) {
        System.out.println(isUgly(128));
    }

    public static boolean isUgly(int n) {
        if (n == 0) {
            return false;
        }
        if (2 <= n && n <= 6) {
            return true;
        }

        while (true) {
            if (n % 2 == 0) {
                n /= 2;
                continue;
            }

            if (n % 3 == 0) {
                n /= 3;
                continue;
            }
            if (n % 5 == 0) {
                n /= 5;
                continue;
            }
            break;
        }
        return n == 1;
    }
}
