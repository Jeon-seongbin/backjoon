package com.leetcode.easy;

import java.util.Stack;

public class ValidParentheses20 {
    public static void main(String[] args) {
    }

    public boolean isValid(String s) {
        Stack<Character> stackBrack = new Stack<>();

        for (char ss : s.toCharArray()) {
            switch (ss) {
                case '(', '{', '[' -> stackBrack.push(ss);
                case ')' -> {
                    if (stackBrack.isEmpty() || stackBrack.pop() != ')') {
                        return false;
                    }
                }
                case '}' -> {
                    if (stackBrack.isEmpty() || stackBrack.pop() != '}') {
                        return false;
                    }
                }
                case ']' -> {
                    if (stackBrack.isEmpty() || stackBrack.pop() != ']') {
                        return false;
                    }
                }
            }
        }

        return stackBrack.isEmpty();
    }
}


