package com.leetcode.midium;

public class FindTheIndexOfTheFirstOccurrenceInAString28 {
    public static void main(String[] args) {
        strStr("sadbutsad", "sad");
    }

    public static int strStr(String haystack, String needle) {
        if (haystack.contains(needle)) {
            return haystack.indexOf(needle);
        }
        return -1;
    }
}
