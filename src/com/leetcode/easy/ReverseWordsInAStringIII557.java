package com.leetcode.easy;

public class ReverseWordsInAStringIII557 {
    public static void main(String[] args) {
        reverseWords("Let's take LeetCode contest");
    }

    public static String reverseWords2(String s) {
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

    public static String reverseWords(String s) {
        char[] arr = s.toCharArray();

        int start = 0;
        int end = 0;
        while (end < arr.length) {

            while (end < arr.length && arr[end] != ' ') {
                end++;
            }

            int endWord = end - 1;

            while (start < endWord) {
                char temp = arr[start];
                arr[start] = arr[endWord];
                arr[endWord] = temp;

                start++;
                end--;
                endWord--;
            }

            start = end + 1;
            end = start;
        }

        return new String(arr);
    }
}
