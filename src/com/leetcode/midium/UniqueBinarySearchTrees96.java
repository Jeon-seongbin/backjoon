package com.leetcode.midium;

public class UniqueBinarySearchTrees96 {
    public static void main(String[] args) {

    }

    //Catalan numbers
    public int numTrees(int n) {
        if (n < 2) {
            return 1;
        }

        int[] result = new int[n + 1];

        result[0] = 1;
        result[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                result[i] = result[i] + result[j] * result[i - j - 1];
            }
        }
        return result[n];
    }
}
