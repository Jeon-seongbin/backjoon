package com.leetcode.easy;

public class BestTimeToBuyAndSellStock121 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public static int maxProfit(int[] prices) {

        int minimal = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minimal) {
                minimal = prices[i];
                continue;
            }
            result = Math.max(prices[i] - minimal, result);

        }

        return result;

    }
}
