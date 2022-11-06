package com.leetcode.hard;

import java.util.Arrays;


public class OrderlyQueue899 {
    public static void main(String[] args) {
        orderlyQueue("rtrgdfgarsegasdfargsdfgxdfbgsftghasdfzdcvzvz", 1);
    }

    public static String orderlyQueue(String s, int k) {
        String result = s;

        if (k == 1) {
            for (int i = 0; i < s.length(); i++) {
                String first = s.substring(i);
                String twice = s.substring(0, i);
                String answer = first + twice;
                int resultCompareTo = answer.compareTo(result);
                if (resultCompareTo < 0) {
                    result = answer;
                }
            }
            return result;
        }

        char[] resultChar = s.toCharArray();
        Arrays.sort(resultChar);
        return new String(resultChar);

    }
}
