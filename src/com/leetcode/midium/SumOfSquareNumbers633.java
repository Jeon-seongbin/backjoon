package com.leetcode.midium;

import java.math.BigDecimal;

public class SumOfSquareNumbers633 {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(4));
    }

    public static boolean judgeSquareSum(int c) {
        if (c == 1) {
            return true;
        }
        long low = 0;
        long high = (long) Math.sqrt(c);

        while (low <= high) {
            long sum = low * low + high * high;
            if (sum == c) {
                return true;
            }
            if (sum < c) {
                low++;
            } else {
                high--;
            }
        }
        return false;
    }

    public static boolean judgeSquareSum1(int c) {
        int start = 1;
        int end = c - 1;

        while (start <= end) {

            BigDecimal startBigDecimal = new BigDecimal(start);
            startBigDecimal = startBigDecimal.multiply(startBigDecimal);

            BigDecimal endBigDecimal = new BigDecimal(end);
            endBigDecimal = endBigDecimal.multiply(endBigDecimal);
            BigDecimal after = endBigDecimal.add(startBigDecimal);

            if (after.compareTo(new BigDecimal(c)) == 0) {
                return true;

            } else if (after.compareTo(new BigDecimal(c)) < 0) {
                start++;
            } else {
                end--;
            }

        }
        return false;
    }
}
