package com.leetcode.easy;

import java.math.BigDecimal;

public class LargestOddNumberInString1903 {
    public static void main(String[] args) {
        largestOddNumber("523");
    }

    public static String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            int a = Character.getNumericValue(num.charAt(i));
            if (a % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}
