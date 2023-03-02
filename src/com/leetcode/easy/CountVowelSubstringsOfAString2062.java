package com.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CountVowelSubstringsOfAString2062 {
    public static void main(String[] args) {
        int result = countVowelSubstrings("aeiouu");
        System.out.println(result);
    }

    public static int countVowelSubstrings(String word) {

        int wordLength = word.length();
        int result = 0;
        if (wordLength < 5) {
            return result;
        }


        Set<Character> set = new HashSet<>();

        for (int i = 0; i < wordLength - 4; i++) {
            set.clear();
            for (int j = i; j < wordLength; j++) {
                char temp = word.charAt(j);

                if (temp == 'a' ||
                        temp == 'e' ||
                        temp == 'i' ||
                        temp == 'o' ||
                        temp == 'u') {
                    set.add(temp);
                    if(set.size() == 5){
                        result++;
                    }

                } else {
                    break;
                }

            }
        }
    return result;

    }

}
