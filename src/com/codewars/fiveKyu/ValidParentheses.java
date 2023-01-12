package com.codewars.fiveKyu;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        boolean result = validParentheses("()");
        System.out.println(result);
    }

    public static boolean validParentheses(String parens) {
        Stack<Character> stack = new Stack<>();

        for (char c : parens.toCharArray()) {
            if (c == '(') {
                stack.add(c);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
