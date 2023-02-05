package com.leetcode.midium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        findAnagrams("cbaebabacd", "abc");
    }

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();
        int len = s.length() - p.length();
        int pLen = p.length();

        int[] cnt = new int[26];

        for (char pChar : p.toCharArray()) {
            cnt[pChar - 'a']++;
        }


        for (int i = 0; i <= len; i++) {
            int[] cntTemp = new int[26];
            for (int j = i; j < pLen + i; j++) {

                char sChar = s.charAt(j);
                cntTemp[sChar - 'a']++;
            }

            if (Arrays.equals(cnt, cntTemp)) {
                result.add(i);
            }
        }

        return result;

    }
}
