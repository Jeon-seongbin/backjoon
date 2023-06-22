package com.leetcode.midium;

public class BestTimeToBuyAndSellStockQithTransactionFee714 {
    public static void main(String[] args) {
        maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2);
    }

    public static int maxProfit(int[] prices, int fee) {
        int sell = 0;
        int buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            buy = Math.max(buy, prices[i] - sell - fee);
            sell = Math.min(sell, prices[i] - buy);
        }
        return sell;
    }

}
