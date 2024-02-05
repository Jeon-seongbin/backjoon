package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterinAString387 {
    public static void main(String[] args) {
        firstUniqChar("aabbl");
    }

    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (char ss : s.toCharArray()) {
            hashMap.put(ss, hashMap.getOrDefault(ss, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (hashMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}
