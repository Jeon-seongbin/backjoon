package com.leetcode.easy;

import java.util.Arrays;

public class MinimumNumberOfMovesToSeatEveryone2037 {
    public static void main(String[] args) {
    }

    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int result = 0;
        for (int i = 0; i < seats.length; i++) {
            if (Math.abs(seats[i]) <= Math.abs(students[i])) {
                result += Math.abs(students[i]) - Math.abs(seats[i]);
            } else {
                result += Math.abs(seats[i]) - Math.abs(students[i]);
            }
        }
        return result;
    }
}
