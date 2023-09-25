package com.leetcode.easy;

import java.util.Arrays;

public class FindtheDifference389 {
    public static void main(String[] args) {
        char a = findTheDifference("a", "g");
        System.out.println(a);
    }

    public static char findTheDifference1(String s, String t) {

        if (s.length() == t.length()) {
            for (int i = 0; i < t.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    return t.charAt(i);
                }
            }
        }

        if (s.length() > t.length()) {
            for (int i = 0; i < t.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    return s.charAt(i);
                }
            }

            return s.charAt(t.length());
        }


        if (s.length() < t.length()) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    return t.charAt(i);
                }
            }

            return t.charAt(s.length());

        }


        return ' ';
    }

    public static char findTheDifference(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        int len = sArr.length;

        for (int i = 0; i < len; i++) {
            if (sArr[i] != tArr[i]) {
                return tArr[i];
            }
        }

        return tArr[len];
    }
}
