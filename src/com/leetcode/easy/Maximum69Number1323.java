package com.leetcode.easy;

public class Maximum69Number1323 {
    public static void main(String[] args) {
    }

    public int maximum69Number(int num) {
        char[] tempChar = ("" + num).toCharArray();
        for (int i = 0; i < tempChar.length; i++) {
            if (tempChar[i] == '6') {
                tempChar[i] = '9';
                break;
            }
        }
        return Integer.parseInt(String.valueOf(tempChar));
    }
}
