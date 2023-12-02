package com.leetcode.easy;


import java.util.HashMap;

public class FindWordsThatCanBeFormedbyCharacters1160 {
    public static void main(String[] args) {
        countCharacters(new String[]{"zz","bt","hat","tree"}, "z") ;
    }

    public static int countCharacters(String[] words, String chars) {



        int answer = 0;
        for (String word : words) {

            HashMap<Character, Integer> charsCount = new HashMap<>();
            for (char c : chars.toCharArray()) {
                charsCount.put(c, charsCount.getOrDefault(c, 0) + 1);
            }

            HashMap<Character, Integer> tempCharCount = charsCount;
            boolean containd = true;

            for (char w : word.toCharArray()) {
                if (tempCharCount.getOrDefault(w, 0) == 0) {
                    containd = false;
                    break;
                }
                tempCharCount.put(w, tempCharCount.get(w) - 1);

            }

            if (containd) {
                answer += word.length();
            }


        }

        return answer;
    }

}
