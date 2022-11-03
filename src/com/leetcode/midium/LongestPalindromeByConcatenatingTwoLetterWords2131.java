package com.leetcode.midium;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromeByConcatenatingTwoLetterWords2131 {
    public static void main(String[] args) {
//        System.out.println(longestPalindrome(new String[]{"lc", "cl", "gg"}));
        System.out.println(longestPalindrome(new String[]{"aa", "aa", "aa", "cc", "cc", "cc"}));
    }

    public static int longestPalindrome(String[] words) {
        int result = 0;
        if (words == null || words.length == 0) {
            return result;
        }

        HashMap<String, Integer> same = new HashMap<>();
        HashMap<String, Integer> diff = new HashMap<>();

        for (String w : words) {
            char w1 = w.charAt(0);
            char w2 = w.charAt(1);

            if (w1 == w2) {
                same.put(w, same.getOrDefault(w, 0) + 1);
            } else {
                diff.put(w, diff.getOrDefault(w, 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : diff.entrySet()) {
            String nowKey = entry.getKey();
            int nowValue = entry.getValue();

            char nowKeyFirst = nowKey.charAt(0);
            char nowKeyTwice = nowKey.charAt(1);

            String reverseKey = "" + nowKeyFirst + nowKeyTwice;
            int reverseValue = diff.getOrDefault(reverseKey, 0);

            result += Math.min(nowValue, reverseValue) * 4;
            diff.put(nowKey, 0);
        }

        boolean isOdd = false;

        for (Map.Entry<String, Integer> entry : same.entrySet()) {

            int nowValue = same.get(entry.getKey());

            if (isOdd == false && nowValue % 2 == 1) {
                isOdd = true;
                result += 2;
            }
            if (nowValue == 1) {
                continue;
            } else if (nowValue % 2 == 0) {
                result += (nowValue * 2);
            } else {
                // aa aa aa
                // bb bb bb
                result += (2 * (nowValue - 1));
            }
        }
        return result;
    }
}
