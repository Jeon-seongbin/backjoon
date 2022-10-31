package com.leetcode.easy;

import java.util.Arrays;

public class ValidAnagram242 {
    public boolean isAnagram(String s, String t) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        if(arr2.length != arr1.length)
            return false;

        return Arrays.equals(arr1, arr2);
    }
}
