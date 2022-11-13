package com.leetcode.midium;

import java.util.Arrays;

import java.util.List;
import java.util.stream.Collectors;

public class ReverseWordsInAString151 {
    public static void main(String[] args) {
        reverseWords("a good   example");
    }

    public static String reverseWords(String s) {
        return  Arrays.stream(s.split(" ")).filter(sss -> !sss.equals("")).reduce((word1, word2) -> word2 + " " + word1)
                .orElse("");
    }
}
