package com.leetcode.easy;

import java.util.HashSet;

public class LongestPalindrome409 {
    public static void main(String[] args) {
        longestPalindrome("abccccdd");
    }

    public static int longestPalindrome(String s) {
        HashSet<Character> hashSet = new HashSet<>();

        int result = 0;
        for (char c : s.toCharArray()) {
            if (hashSet.contains(c)) {
                hashSet.remove(c);
                result += 2;
            } else{
                hashSet.add(c);
            }
        }

        if(!hashSet.isEmpty()){
            result++;
        }
        return result;
    }
}
