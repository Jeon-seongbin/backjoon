package com.leetcode.midium;

import java.util.HashMap;
import java.util.stream.Collectors;

public class SortCharactersByFrequency451 {
    public static void main(String[] args) {

    }

    public static String frequencySort(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        return hashMap.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                .map(obj -> String.valueOf(obj.getKey()).repeat(obj.getValue()))
                .map(String::valueOf)
                .collect(Collectors.joining());
//
//        return hashMap.entrySet().stream()
//                .sorted(Map.Entry.comparingByValue((o1, o2) -> -o1.compareTo(o2)))
//                .map(obj -> String.valueOf(obj.getKey()).repeat(obj.getValue()))
//                .map(String::valueOf)
//                .collect(Collectors.joining());

    }
}
