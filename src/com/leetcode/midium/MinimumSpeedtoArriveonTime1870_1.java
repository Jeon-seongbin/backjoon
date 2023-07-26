package com.leetcode.midium;

public class MinimumSpeedtoArriveonTime1870_1 {
    public static void main(String[] args) {

    }

    public int minSpeedOnTime(int[] dist, double hour) {

        int result = -1;

        int start = 1;
        int end = 1000000000;

        while (start < end) {
            double calculate = 0;
            int mid = start + (end - start) / 2;
            for (int i = 0; i < dist.length; i++) {
                calculate = Math.ceil(calculate);
                calculate += Double.valueOf(dist[i]) / Double.valueOf(mid);
            }

            if (hour <= calculate) {
                end = mid - 1;
                result = mid;
            } else {
                start = mid + 1;
            }

        }

        return result;
    }
}
