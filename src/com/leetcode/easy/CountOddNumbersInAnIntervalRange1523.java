package com.leetcode.easy;

public class CountOddNumbersInAnIntervalRange1523 {
    public static void main(String[] args) {

    }

    public int countOdds(int low, int high) {
        int total = high - low + 1;
        if (total % 2 == 0) {
            return total / 2;
        }
        if (low % 2 == 1) {
            return total / 2 + 1;
        }
        return total / 2;
    }

    public int countOdds1(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (i % 2 != 0) count++;
        }
        return count;

    }
}
