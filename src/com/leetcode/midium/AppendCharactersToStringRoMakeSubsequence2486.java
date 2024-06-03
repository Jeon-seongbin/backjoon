package com.leetcode.midium;

public class AppendCharactersToStringRoMakeSubsequence2486 {
    public static void main(String[] args) {

    }

    public int appendCharacters(String s, String t) {
        int sIndex = 0;
        int tIndex = 0;

        while (sIndex < s.length() && tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                tIndex++;
            }
            sIndex++;
        }

        return t.length() - tIndex;

    }
}
