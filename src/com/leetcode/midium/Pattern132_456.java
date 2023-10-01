package com.leetcode.midium;

import java.util.Stack;

public class Pattern132_456 {
    public static void main(String[] args) {
        find132pattern(new int[]{5, 3, 2});
    }

    public static boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        int temp = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < temp) {
                return true;
            }

            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                temp = stack.pop();
            }

            stack.push(nums[i]);
        }

        return false;
    }
}
