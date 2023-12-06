package com.leetcode.easy;

public class Largest3SameDigitNumberInString2264 {
    public static void main(String[] args) {
        largestGoodInteger("222");
    }

    public static String largestGoodInteger(String num) {
        int maxNumber = Integer.MIN_VALUE;
        for (int i = 0; i < num.length() - 2; i++) {
            char temp = num.charAt(i);
            int count = 0;
            for (int j = i; j < i + 3; j++) {
                if (temp == num.charAt(j)) {
                    count++;
                }
            }
            if (count == 3) {
                maxNumber = Math.max(maxNumber, Integer.parseInt("" + num.charAt(i)));
            }
        }
        if (maxNumber == Integer.MIN_VALUE) {
            return "";
        }
        String result = "";
        result += "" + maxNumber + maxNumber + maxNumber;
        return result;
    }
}
