package com.leetcode.midium;

public class KokoEatingBananas875 {
    public static void main(String[] args) {

    }

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        for (int p : piles) {
            right = Math.max(right, p);
        }

        while (left < right) {
            int mid = (left + right) / 2;
            if (check(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public boolean check(int[] piles, int mid, int h) {
        int hours = 0;
        for (int p : piles) {
            int time = p / mid;
            hours += time;
            if (p % mid != 0) {
                hours++;
            }
        }
        return hours <= h;
    }

}
