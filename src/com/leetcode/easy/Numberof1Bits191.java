package com.leetcode.easy;

public class Numberof1Bits191 {
    public static void main(String[] args) {
        hammingWeight(00000000000000000000000000001011);
    }
    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {

        String aaa = Integer.toBinaryString(n);

        aaa =aaa.replace("0", "");
        return aaa.length();


    }
}
