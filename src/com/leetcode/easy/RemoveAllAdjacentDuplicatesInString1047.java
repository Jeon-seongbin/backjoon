package com.leetcode.easy;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString1047 {
    public String removeDuplicates(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ss : s.toCharArray()) {
            if (!stack.empty() && stack.peek() == ss) {
                stack.pop();
                continue;
            }
            stack.add(ss);

        }
        StringBuilder result = new StringBuilder();
        while (!stack.empty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }
}
