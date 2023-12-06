package com.leetcode.easy;

public class CalculateMoneyInLeetcodeBank1716 {
    public static void main(String[] args) {
        totalMoney(20);
    }

    public static int totalMoney(int n) {

        int temp = 0;
        int startMoney = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (i % 7 == 0) {
                startMoney++;
                temp = 0;
                temp = temp + startMoney;
            } else {
                temp++;
            }


            sum += temp;
        }
        return sum;
    }
}
