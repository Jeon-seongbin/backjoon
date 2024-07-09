package com.codingTest.lobot;

import java.util.*;

public class Main {
    public static String longestCommonPrefix(List<String> words) {
        if (words == null || words.isEmpty()) {
            return "";
        }

       Collections.sort(words);

        String first = words.get(0);
        String last = words.get(words.size() - 1);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < first.length() && i < last.length(); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                break;
            }
            result.append(first.charAt(i));
        }

        return result.toString();
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
