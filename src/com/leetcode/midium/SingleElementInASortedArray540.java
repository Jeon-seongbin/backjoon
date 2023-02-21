package com.leetcode.midium;

import java.util.HashMap;

public class SingleElementInASortedArray540 {
    public static void main(String[] args) {

    }

    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        return hashMap.entrySet().stream().filter(obj -> obj.getValue() == 1).findFirst().get().getKey();
    }
}
