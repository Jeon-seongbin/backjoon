package com.leetcode.midium;

public class BestTimeToBuyAndSellStockQithTransactionFee714 {
    public static void main(String[] args) {
        maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2);
    }

    public static int maxProfit(int[] prices, int fee) {
        // 현재 돈
        int cash = 0;

        // 가지고있는 주식
        int prevStockPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {

            // 현재 주식가격에서 - 가지고있는 주식을 팔고 - 수수료 까지 떼면 돈이 나오는데
            // 최댓값을 구한다
            cash = Math.max(cash, prices[i] - prevStockPrice - fee);

            // 과거 주식 가격에서 가장 낮은것을 구한다
            prevStockPrice = Math.min(prevStockPrice, prices[i] - cash);

        }

        return cash;
    }

}
