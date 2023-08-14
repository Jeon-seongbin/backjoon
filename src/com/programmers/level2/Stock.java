package com.programmers.level2;

import java.util.Stack;

public class Stock {
    public static void main(String[] args) {
        solution1(new int[]{1, 2, 3, 2, 3});
    }

    public static int[] solution1(int[] prices) {
        int[] ans = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                ans[i]++;
                if (prices[i] > prices[j]) {
                    break;
                }
            }
        }
        return ans;
    }

    public static int[] solution(int[] prices) {
        int[] dp = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int nowIndex = stack.pop();
                dp[nowIndex] = i - nowIndex;
            }
            stack.add(i);
        }

        while (!stack.isEmpty()) {
            int nowIndex = stack.pop();
            dp[nowIndex] = prices.length - 1 - nowIndex;
        }

        return dp;
    }
}
