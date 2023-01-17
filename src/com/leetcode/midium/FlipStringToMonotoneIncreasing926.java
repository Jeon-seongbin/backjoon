package com.leetcode.midium;

public class FlipStringToMonotoneIncreasing926 {
    public static void main(String[] args) {
        minFlipsMonoIncr("101");
    }

    public static int minFlipsMonoIncr1(String s) {
        int result = 0;
        int noZeroFlip = 0;

        for (char sChar : s.toCharArray()) {
            if (sChar == '0') {
                result = Math.min(noZeroFlip, result + 1);
            } else {
                noZeroFlip++;
            }
        }
        return result;
    }

    public static int minFlipsMonoIncr(String s) {
        int count = 0;
        int result = 0;
        for (char sChar : s.toCharArray()) {
            if (sChar == '1') {
                count++;
            } else if (count > 0 && sChar == '0') {
                count--;
                result++;
            }
        }
        return result;
    }
}
