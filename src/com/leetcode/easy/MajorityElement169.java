package com.leetcode.easy;

import java.util.HashMap;

public class MajorityElement169 {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
//        System.out.println(majorityElement(new int [] {3,2,3}));

    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int num : nums) {
            hashmap.put(num, hashmap.getOrDefault(num, 0) + 1);
        }
        int majority = nums.length / 2;
        return hashmap.entrySet().stream().filter(obj -> obj.getValue() > majority).findFirst().get().getKey();
    }
}
