package com.leetcode.easy;

public class ReverseStringII541 {
    public static void main(String[] args) {
        reverseStr("abcdefg", 8);
    }

    public static String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        int len = ch.length;

        for (int i = 0; i < len; i += k * 2) {
            char temp;

            int start = i;
            int end = Math.min(i + k - 1 , len - 1);

            while(start < end){
                temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;
                start++;
                end--;
            }
        }

        return new String(ch);

    }
}
