package com.leetcode.easy;

import java.util.HashMap;

public class LemonadeChange860 {
    public static void main(String[] args) {
        boolean result = lemonadeChange(new int[]{5, 5, 10, 10, 20});
        System.out.println(result);
    }

    public static boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int bill : bills) {
            if (bill == 5) {
                five++;
            }
            if (bill == 10) {
                ten++;
                if (five == 0) {
                    return false;
                }
                five--;
            }
            if (bill == 20) {
                if (0 < five && 0 < ten) {
                    five--;
                    ten--;
                } else if (3 <= five) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }


        return true;
    }
}
