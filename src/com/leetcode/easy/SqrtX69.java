package com.leetcode.easy;

import java.io.IOException;

import java.math.BigDecimal;

public class SqrtX69 {
    public static void main(String[] args) throws IOException {

int x =6;
        long start = 0;
        long end = x;
        long mid = 0;
        long result = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;

            BigDecimal midmid = new BigDecimal(mid).multiply(new BigDecimal(mid));
            if (midmid.compareTo(new BigDecimal(x)) == 0) {
                result = mid;
                break;
            }
            if (midmid.compareTo(new BigDecimal(x)) > 0) {
                end = mid - 1;

            } else {
                start = mid + 1;
                result = mid;
            }
        }

        System.out.println(result);

    }
}
