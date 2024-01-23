package com.leetcode.easy;

import java.util.HashMap;

public class ClimbingStairs70_2 {
    public static void main(String[] args) {

    }

    public int climbStairs(int n) {

        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {        HashMap<Integer, Boolean> hashMap = new HashMap<>();

            int [] result = new int[2];

            for (int i = 0; i < nums.length; i++) {
                hashMap.put(i + 1, false);
            }


            for(int i = 0 ; i < nums.length; i++){

                if(hashMap.get(nums[i])){
                    result[0] = nums[i];
                }
                hashMap.put(nums[i], true);

            }

            result[1] = hashMap.entrySet()
                    .stream()
                    .filter(obj -> obj.getValue() == false).findFirst().get().getKey();

            return result;
            return 3;
        }
        int[] a = new int[n + 1];

        a[0] = 1;
        a[1] = 2;
        a[2] = 3;


        for (int i = 3; i <= n; i++) {
            a[i] = a[i - 1] + a[i - 2];

        }

        return a[n];
    }
}
