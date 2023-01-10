package com.acmicpc.season1.company4;

public class Main2 {
    public static void main(String[] args) {

        int[] userInput = {7, 1, 5, 3, 6, 4};
        int result = maxProfit(userInput);
        System.out.println(result);
    }

    static public int maxProfit(int[] prices) {
        int result = 0;

        int lowTemp = 0;
        int lowIndex = 0;

        for (int price : prices) {
            if (lowTemp < price) {
                lowTemp = price;
            }
        }

//        for(int price : prices){
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lowTemp) {

                lowTemp = prices[i];
                lowIndex = i;
            }
        }

//        System.out.println(lowTemp);
//        System.out.println(lowIndex);

        int sumBefore = 0;
        for (int i = lowIndex; i < prices.length; i++) {
            if (lowTemp < prices[i]) {
                int sumNow = prices[i] - lowTemp;
                if (sumBefore < sumNow) {
                    sumBefore = sumNow;
                }
            }
        }
//        System.out.println(sumBefore);
        return sumBefore;
    }
}
