package com.leetcode.midium;

import java.util.Arrays;

public class PermutationinString567 {
    public static void main(String[] args) {
        boolean result = checkInclusion("ab", "eidboaab");
        System.out.println(result);
    }

    /*
    Input: s1 = "ab", s2 = "eidbaooo"
    Output: true
    Explanation: s2 contains one permutation of s1 ("ba").
     */
    public static boolean checkInclusion(String s1, String s2) {

        int[] cnt = new int[26];

        for (char c : s1.toCharArray()) {
            cnt[c - 'a']++;
        }

        int s1Len = s1.length();
        int s2Len = s2.length();

        for (int i = 0; i < s2Len - s1Len + 1; i++) {
            int[] cnt2 = new int[26];

            for (int j = i; j < i + s1Len; j++) {

                cnt2[s2.charAt(j) - 'a']++;
            }
            if (Arrays.equals(cnt, cnt2)) return true;
        }

        return false;

    }
/*
    public static boolean checkInclusion1(String s1, String s2) {
        int len = s2.length() - s1.length();
        int s1Len = s1.length();


        for (int i = 0; i <= len; i++) {
            String temp = "";
            String reverseTemp = "";
            for (int j = i; j < i + s1Len; j++) {
                temp += "" + s2.charAt(j);
            }
            if (temp.equals(s1)) {
                return true;
            }
            for (int k = s1Len - 1; k >= 0; k--) {
                reverseTemp += "" + s1.charAt(k);
            }

            if (reverseTemp.equals(temp)) {
                return true;
            }

        }

        return false;
    }

 */
}
