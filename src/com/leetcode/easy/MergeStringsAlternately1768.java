package com.leetcode.easy;

public class MergeStringsAlternately1768 {
    public static void main(String[] args) {
        mergeAlternately("ab", "pqrs");
    }

    public static String mergeAlternately(String word1, String word2) {
        String result = "";

        int word1Size = word1.length();
        int word2Size = word2.length();

        int word1index = 0;
        int word2index = 0;

        int turn = 1;

        while (true) {
            if (word1index >= word1Size && word2index >= word2Size) {
                break;
            }

            if (turn % 2 == 1) {
                if (word1index <= word1Size - 1) {
                    result += "" + word1.charAt(word1index);

                }
                word1index++;


            } else {
                if (word2index <= word2Size - 1) {
                    result += "" + word2.charAt(word2index);

                }
                word2index++;

            }
            turn++;
        }

        return result;
    }
}
