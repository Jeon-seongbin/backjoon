package com.leetcode.midium;

public class MinimumNumberOfDaysToMakeMBouquets1482 {
    public static void main(String[] args) {

    }

    public int minDays(int[] bloomDay, int m, int k) {

        int minDays = -1;
        int start = 0;
        int end = 0;
        for (int b : bloomDay) {
            end = Math.max(b, end);
        }

        while (start <= end) {
            int mid = (start + end) / 2;
            int bucketCount = 0;
            int interval = 0;
            for (int i = 0; i < bloomDay.length; i++) {
                if (bloomDay[i] <= mid) {
                    interval++;
                } else {
                    interval = 0;
                }
                if (interval == k) {
                    bucketCount++;
                    interval = 0;
                }
            }
            if (m <= bucketCount) {

                minDays = m;
                start = m + 1;
            } else {
                end = m - 1;
            }
        }
        return minDays;

    }
}
