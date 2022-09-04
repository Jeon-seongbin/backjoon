package com.leetcode.midium;

public class LongestPalindromicSubstring5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("ac"));
    }

    public static String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        int start = 0;
        int end = 0;

        for (int gap = 0; gap < s.length(); gap++) {
            for (int i = 0, j = gap; j < s.length(); i++, j++) {
                if (gap == 0) {
                    dp[i][j] = true;
                    continue;
                }

                if (gap == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                } else if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                }
                if (dp[i][j]) {
                    start = i;
                    end = j;
                }
            }
        }

        return s.substring(start, end + 1);
    }

}
