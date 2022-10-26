package com.leetcode.midium;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum523 {
    public static void main(String[] args) {
        checkSubarraySum(new int[]{1, 2, 3, 4, 5}, 0);
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> remainderMap = new HashMap<>();
        // K : runningSum
        // V : index

        remainderMap.put(0, -1);

        int runningSum = 0;

        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            runningSum %= k;
            if (remainderMap.containsKey(runningSum)) {
                if (i - remainderMap.get(runningSum) >= 2) {
                    return true;
                }
            } else {
                remainderMap.put(runningSum, i);
            }
        }
        return false;
    }
}
