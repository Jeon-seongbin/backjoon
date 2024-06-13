package com.leetcode.easy;

import java.util.Stack;

public class MinimumNumberofChairsinaWaitingRoom3168 {
    public static void main(String[] args) {

    }

    public int minimumChairs(String s) {

        Stack<Character> stack = new Stack<>();
        int length = 0;
        for (char c : s.toCharArray()) {
            if (c == 'E') {
                stack.push(c);
                length = Math.max(stack.size(), length);
            }else{
                stack.pop();
            }
        }
        return length;
    }
}
