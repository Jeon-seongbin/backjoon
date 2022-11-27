package com.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CheckIfNAndItsDoubleExist1346 {
    public static void main(String[] args) {
        System.out.println(checkIfExist(new int[]{-2, 0, 10, -19, 4, 6, -8}));
    }

    public static boolean checkIfExist(int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int a : arr) {
            hashMap.put(a, hashMap.getOrDefault(a, 0) + 1);
        }

        for (int a : arr) {
            if (hashMap.containsKey(a * 2)) {
                if (a == 0 && hashMap.get(a) < 2) {
                    continue;
                }
                return true;
            }
        }
        return false;
    }
}
