package com.leetcode.easy;

import java.util.HashMap;

public class SetMismatch645 {
    public static void main(String[] args) {
        findErrorNums(new int[]{1, 2, 2, 3});
    }

    public static int[] findErrorNums(int[] nums) {

        HashMap<Integer, Boolean> hashMap = new HashMap<>();

        int[] result = new int[2];

        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(i + 1, false);
        }

        for (int i = 0; i < nums.length; i++) {

            if (hashMap.get(nums[i])) {
                result[0] = nums[i];
            }
            hashMap.put(nums[i], true);
        }

        result[1] = hashMap.entrySet()
                .stream()
                .filter(obj -> obj.getValue() == false).findFirst().get().getKey();

        return result;
    }

}
