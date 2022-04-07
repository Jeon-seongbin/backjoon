package com.acmicpc.company7;

public class Main3 {


    public static void main(String[] args) {
        int[] nums = new int[1];
        nums[0] = 1;
//        nums[1] = 7;
//        nums[2] = 7;
//        nums[3] = 8;
//        nums[4] = 8;
//        nums[5] = 10;
        int target = 1;
        Main3 m = new Main3();
        m.searchRange(nums, target);
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {

                result[0] = i;
                if (nums.length == 1) {
                    result[1] = i;

                } else {

                    result[1] = i + 1;
                }
                return result;

            }
        }

        return result;
    }
}

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
