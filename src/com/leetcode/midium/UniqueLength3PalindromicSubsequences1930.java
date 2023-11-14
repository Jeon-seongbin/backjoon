package com.leetcode.midium;

import java.util.HashSet;

public class UniqueLength3PalindromicSubsequences1930 {
    public static void main(String[] args) {

    }

    public int countPalindromicSubsequence(String s) {
        int result = 0;

        for (int i = 'a'; i < 'z'; i++) {
            int firstOccurence = s.indexOf(i);
            int lastOccurrence = s.lastIndexOf(i);

            if (firstOccurence != -1 && lastOccurrence != -1 && firstOccurence < lastOccurrence) {
                HashSet<Character> set = new HashSet<>();

                for (int z = firstOccurence + 1; z < lastOccurrence; z++) {

                    set.add(s.charAt(z));
                }
                result += set.size();
            }

        }

        return result;
    }
}
