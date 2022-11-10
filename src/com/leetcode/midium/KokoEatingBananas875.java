package com.leetcode.midium;

public class KokoEatingBananas875 {
    public static void main(String[] args) {

    }

    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1000000000;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(piles, mid, h)) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }

    public static boolean check(int[] piles, int k, int h) {

        int hours = 0;
        for (int pile : piles) {
            int div = pile / k;
            hours += div;
            if (pile % k != 0) {
                hours++;
            }
        }
        return hours <= h;
    }
}
