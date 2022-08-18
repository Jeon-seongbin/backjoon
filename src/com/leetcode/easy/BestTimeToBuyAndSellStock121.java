package com.leetcode.easy;

public class BestTimeToBuyAndSellStock121 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }

    public static int maxProfit(int[] prices) {


        int max = 0;
        int min = prices[0];

        for(int i = 1 ; i < prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }
            max = Math.max(prices[i] - min , max);
        }
        return max;
    }
}
