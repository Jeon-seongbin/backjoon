package com.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;

public class RankTransformOfArray1331 {
    public static void main(String[] args) {

    }

    public int[] arrayRanktransform(int[] arr) {


        int[] result = new int[arr.length];
        System.arraycopy(arr, 0, result, 0, arr.length);

        Arrays.sort(arr);

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int ranked = 1;
        for (int i = 0; i < arr.length; i++) {
            if (hashMap.containsKey(arr[i])) {
                continue;
            }
            hashMap.put(arr[i], ranked);
            ranked++;
        }

        for (int i = 0; i < arr.length; i++) {

            result[i] = hashMap.get(result[i]);
        }
        return result;
    }

}