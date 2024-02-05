package com.leetcode.midium;

public class EvaluateReversePolishNotation150 {
    public static void main(String[] args) {

    }

    public int evalRPN(String[] tokens) {
        int[] dp = new int[tokens.length];
        int top = 0;

        for (String token : tokens) {

            if (token.equals("+")) {
                int b = dp[--top];
                int a = dp[--top];

                dp[top++] = a + b;
            } else if (token.equals("-")) {

                int b = dp[--top];
                int a = dp[--top];

                dp[top++] = a - b;
            } else if (token.equals("*")) {
                int b = dp[--top];
                int a = dp[--top];

                dp[top++] = a * b;
            } else if (token.equals("/")) {
                int b = dp[--top];
                int a = dp[--top];

                dp[top++] = a / b;
            } else {
                dp[top++] = Integer.parseInt(token);
            }
        }

        return dp[0];

    }
}
