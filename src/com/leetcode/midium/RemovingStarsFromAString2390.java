package com.leetcode.midium;

public class RemovingStarsFromAString2390 {
    public static void main(String[] args) {
        removeStars("erase*****");
    }

    public static String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
