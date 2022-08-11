package com.leetcode.easy;

public class FibonacciNumber509 {
    public static void main(String[] args) {
        System.out.println(fib(2));
    }

    public static int fib(int n) {
        int[] arrays = new int[31];

        arrays[1] = 1;
        arrays[2] = 1;
        arrays[3] = 2;
        arrays[4] = 3;

        for (int i = 4; i < n + 1; i++) {
            arrays[i] = arrays[i - 1] + arrays[i - 2];

        }
        int result = arrays[n];
        return result;
    }
}
