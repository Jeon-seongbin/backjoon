package com.leetcode.midium;

import java.util.Arrays;

public class KokoEatingBananas875 {
    public static int minEatingSpeed(int[] piles, int h) {
        int left = Arrays.stream(piles).min().getAsInt();
        int right = Arrays.stream(piles).max().getAsInt();

        while (left < right) {
            int mid = (left + right) / 2;
            if (binarySearch(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static boolean binarySearch(int[] piles, int mid, int h) {
        int a = 0;
        for (int p : piles) {

            a += p / mid;
            if( p % mid != 0){
                a++;
            }
        }
        return a <= h;
    }

    public static void main(String[] args) {
        minEatingSpeed(new int[]{3, 6, 7, 11}, 8);
    }
}
