package com.leetcode.midium;

public class IntegerToRoman12 {
    public static void main(String[] args) {
    }

    public String intToRoman(int num) {
        int[] intCode = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < intCode.length; i++) {
            while (intCode[i] <= num) {
                ans.append(symbol[i]);
                num -= intCode[i];
            }
        }
        return ans.toString();
    }
}
