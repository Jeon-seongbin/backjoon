package com.leetcode.easy;

import java.util.Arrays;

public class BuyTwoChocolates2706 {
    public static void main(String[] args) {

    }

    public int buyChoco(int[] prices, int money) {

        Arrays.sort(prices);

        int result = money - prices[0] - prices[1];
        if (result < 0) {
            return money;
        }

        return result;
    }
}
