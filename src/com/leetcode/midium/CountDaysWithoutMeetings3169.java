package com.leetcode.midium;

import java.util.Arrays;

public class CountDaysWithoutMeetings3169 {
    public static void main(String[] args) {
        int[][] a = {{5, 7}, {1, 3}, {9, 10}};
        countDays(10, a);

    }


    public static int countDays(int days, int[][] meetings) {
        int[] dayCount = new int[days];

        for (int[] meeting : meetings) {
            for(int i = meeting[0] -1 ; i <= meeting[1]-1;  i++){
                dayCount[i]++;
            }
        }

        int result = (int)Arrays.stream(dayCount).filter(obj -> obj == 0).count();

        return result;
    }
}
