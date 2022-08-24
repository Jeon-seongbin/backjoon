package com.leetcode.midium;

public class JumpGame55 {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    }


    public static boolean canJump(int[] nums) {
        int goalIndex = nums[nums.length - 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= goalIndex) {
                goalIndex = i;
            }
        }
        return goalIndex == 0;
    }
}
