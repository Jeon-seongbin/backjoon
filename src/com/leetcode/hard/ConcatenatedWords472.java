package com.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ConcatenatedWords472 {
    public static void main(String[] args) {
        List<String> words = findAllConcatenatedWordsInADict(new String[]{"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"});
        for (String word : words) {
            System.out.println(word);
        }
    }

    public static HashSet<String> set;
    public static HashSet<String> dict;
    public static List<String> result;

    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        set = new HashSet<>();
        dict = new HashSet<>(Arrays.asList(words));
        result = new ArrayList<>();

        for(String word: words){
            if(isValid(word)){
                result.add(word);
            }
        }
        return result;
    }

    public static boolean isValid(String input) {
        if (set.contains(input)) {
            return true;
        }

        for (int index = 1; index < input.length(); index++) {
            String s1 = input.substring(0, index);
            String s2 = input.substring(index, input.length());

            if(dict.contains(s1)){
                if(dict.contains(s2) || isValid(s2)){
                    set.add(input);
                    return true;
                }
            }
        }
        return false;
    }
}
