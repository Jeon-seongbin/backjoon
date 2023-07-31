package com.leetcode.hard;

public class MaximumRunningTimeOfNComputers2141 {
    public static void main(String[] args) {

    }

    public long maxRunTime(int n, int[] batteries) {

        long left = 1;
        long right = 0;

        for (int battery : batteries) {
            right += battery;
        }

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (canRunAllComputers(n, batteries, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    public boolean canRunAllComputers(int n, int[] batteries, long mid) {
        long computersRunnings = 0;

        for (int battery : batteries) {
            computersRunnings += Math.min(battery, mid);
        }

        return computersRunnings >= mid * n;
    }
}
