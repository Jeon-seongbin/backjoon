package com.leetcode.easy;

public class NthTribonacciNumber1137 {
    public static void main(String[] args) {
        System.out.println(tribonacci(25));
    }

    public static int tribonacci(int n) {
        int resultArrays[] = new int[39];

        resultArrays[1] = 1;
        resultArrays[2] = 1;
        resultArrays[3] = 2;
        resultArrays[4] = 4;

        for (int i = 5; i < n + 1; i++) {
            resultArrays[i] = resultArrays[i - 1] + resultArrays[i - 2] + resultArrays[i - 3];
        }

        return resultArrays[n];
    }
}
