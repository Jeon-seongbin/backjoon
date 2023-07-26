package com.programmers.level3;

import java.util.Arrays;

public class Immigration {
    public static void main(String[] args) {
        solution(6, new int[]{7, 10});
    }

    public static long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = 0;

        long left = 0;
        long right = times[times.length - 1] * (long) n;


        while (left <= right) {
            long mid = left + (right - left) / 2;

            long tempTimes = 0;
            for (int time : times) {
                tempTimes += mid / time;
            }

            if (n <= tempTimes) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}