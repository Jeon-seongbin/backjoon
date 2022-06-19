package com.leetcode.easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FindSmallestLetterGreaterThanTarget744 {
    public static void main(String[] args) {
        System.out.println(nextGreatestLetter(new char[]{'e', 'e', 'e', 'e', 'e', 'e', 'n', 'n', 'n', 'n'}, 'e'));

    }

    public static char nextGreatestLetter(char[] letters, char target) {

        for (int i = 0; i < letters.length; i++) {

            if( target< letters[i]){
                return letters[i];
            }

            if(target == letters[i]){
                if(letters.length <= i + 1 ){
                    return letters[0];
                }
                if(letters[i + 1] == target){
                    continue;
                }

                return letters[++i];
            }
        }
        return letters[0];
    }
}
