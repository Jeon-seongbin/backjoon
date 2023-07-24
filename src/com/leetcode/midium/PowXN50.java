package com.leetcode.midium;

public class PowXN50 {
    public static void main(String[] args) {
        myPow(2.0, 5);
    }

    public static double myPow(double x, int n) {

        int posExponent = Math.abs(n);
        double result = powHelper(x, posExponent);
        if (n < 0) {
            return 1 / result;
        }

        return result;
    }

    public static double powHelper(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }
        double resultWithHalfN = powHelper(x, n / 2);

        if (n % 2 == 0) {
            return resultWithHalfN * resultWithHalfN;
        }

        return resultWithHalfN * resultWithHalfN * x;
    }
}
