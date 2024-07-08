package com.codingTest.lobot;

import java.util.*;

public class Main {


    public static String longestCommonPrefix(List<String> words) {
        if (words == null) {
            return "";
        }

        if (words.isEmpty()) {
            return "";
        }

        if (words.get(0).isEmpty()) {
            return "";
        }


        String prefix = words.get(0);
        for (int i = 1; i < words.size(); i++) {
            while (words.get(i).indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(Arrays.asList("flower", "flow", "flight")));   // -> "fl"
        System.out.println(longestCommonPrefix(Arrays.asList("flow", "flower", "flowchart")));   // -> "flow"
        System.out.println(longestCommonPrefix(Arrays.asList("flower", "flow", "flowchart")));   // -> "flow"
        System.out.println(longestCommonPrefix(Arrays.asList("car", "cat", "dog", "bird", "cow", "rabbit")));   // -> ""
        System.out.println(longestCommonPrefix(Arrays.asList("one word")));   // -> "one word"
        System.out.println(longestCommonPrefix(Arrays.asList("")));   // -> ""
        System.out.println(longestCommonPrefix(Arrays.asList()));   // -> ""
    }
}
