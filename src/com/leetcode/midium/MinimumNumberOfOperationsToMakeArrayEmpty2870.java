package com.leetcode.midium;

import java.util.HashMap;

public class MinimumNumberOfOperationsToMakeArrayEmpty2870 {
    public static void main(String[] args) {
        minOperations(new int[]{2, 2, 2, 4, 2, 4});
    }

    public static int minOperations(int[] nums) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int n : nums) {
            hashMap.put(n, hashMap.getOrDefault(n, 0) + 1);
        }

        int result = 0;

        for (int n : hashMap.values()) {
            if (n == 1) {
                return -1;
            }
            result += (int) Math.ceil((double) n / 3);

        }

        return result;
    }
}
