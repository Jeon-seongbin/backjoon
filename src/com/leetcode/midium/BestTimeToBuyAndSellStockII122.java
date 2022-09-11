package com.leetcode.midium;

public class BestTimeToBuyAndSellStockII122 {
    public static void main(String[] args) {
    }

    public static int maxProfit(int[] prices) {
        int result = 0;
        if (prices == null && prices.length == 0) {
            return result;
        }
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                result += prices[i + 1] - prices[i];
            }
        }
        return result;
    }
}
