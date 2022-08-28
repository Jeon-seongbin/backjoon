package com.leetcode.midium;

import java.util.ArrayList;
import java.util.List;

public class WordBreak139 {
    public static void main(String[] args) {
        ArrayList<String> inputs = new ArrayList<>();
        inputs.add("leet");
        inputs.add("code");
        wordBreak("leetcode", inputs);
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;

        for (int i = 0; i < len; i++) {
            if (!dp[i]) {
                continue;
            }

            for (String word : wordDict) {
                int wordLength = word.length();
                int end = i + wordLength;

                if (end > s.length()) {
                    continue;
                }

                if (dp[end]) {
                    continue;
                }


                if (s.substring(i, end).equals(word)) {
                    dp[end] = true;
                }
            }


        }
        return dp[s.length()];
    }
}
