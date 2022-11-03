package com.leetcode.easy;

public class ReverseWordsInAStringIII557 {
    public static void main(String[] args) {
        reverseWords("Let's take LeetCode contest");
    }

    public static String reverseWords(String s) {
        String[] words = s.split(" ");

        for (int i = 0; i < words.length; i++) {

            String temp = "";
            for (int j = words[i].length() - 1; j >= 0; j--) {
                temp += "" + words[i].charAt(j);
            }
            words[i] = temp;
        }
        s = "";
        for (int i = 0; i < words.length; i++) {
            s += words[i];
            if (i != words.length - 1) {
                s += " ";
            }
        }
        return s;
    }
}
