package com.programmers.level3;

import java.util.Arrays;

public class Immigration {
    public static long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long start = 0;
        long end = times[times.length - 1] * (long) n;

        while (start <= end) {
            long mid = start + (end - start) / 2;
            long tempTime = 0;

            for (int time : times) {
                tempTime += mid / time;
                // mid : 모든 심사관들에게 주어진 시간이다. 따라서 tempTime 은 모든 심사관들이 mid분 동안 심사한 사람의 수가 된다.
                // mid 시간 동안 모든 사람이 심사 가능한지를 계산한다

                // 입국 심사 1칸에 걸리는 시간
                // mid 가 60 일때 7, 10 계산결과는 4, 3 -> timeTemp -> 7
                // 사람수가 6명인데 7명 가능하다고 떠서 mid 값을 줄인다
            }

            if (tempTime >= n) {
                end = mid - 1;

            } else {
                start = mid + 1;
                answer = start;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        solution(6, new int[]{7, 10});
    }
}