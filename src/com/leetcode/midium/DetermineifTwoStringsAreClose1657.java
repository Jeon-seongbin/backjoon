package com.leetcode.midium;

import java.util.Arrays;

public class DetermineifTwoStringsAreClose1657 {
    public static void main(String[] args) {

    }

    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()){
            return false;
        }

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for (char w : word1.toCharArray()) {
            arr1[w - 'a']++;
        }

        for (char w : word2.toCharArray()) {
            arr2[w - 'a']++;
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for(int i = 0 ; i < 26 ; i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }

        return true;
    }
}
