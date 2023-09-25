package com.leetcode.midium;

import java.util.Arrays;
import java.util.HashMap;

public class LongestStringChain1048 {
    public static void main(String[] args) {
        longestStrChain(new String[]{
                "a", "b", "ba", "bca", "bda", "bdca"
        });
    }

    public static int longestStrChain(String[] words) {
        
        HashMap<String, Integer> map = new HashMap<>();
        Arrays.sort(words, (o1, o2) -> o1.length() - o2.length());
        int res = 0;
        for (String word : words) {
            int best = 0;
            for (int i = 0; i < word.length(); i++) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                best = Math.max(best, map.getOrDefault(prev, 0) + 1);
            }
            map.put(word, best);
            res = Math.max(res, best);
        }
        return res;
    }


}
