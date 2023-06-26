package com.programmers.level2;

import java.util.Arrays;

public class PatriotMissile {
    public static void main(String[] args) {

        solution(new int[][]{
                {4, 5},
                {4, 8},
                {10, 14},
                {11, 13},
                {5, 12},
                {3, 7},
                {1, 4}
        });
    }

    public static int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, (o1, o2) -> (o1[1] - o2[1]));

        int before = 0;

        for (int i = 0; i < targets.length; i++) {
            if (targets[i][0] >= before) {
                answer++;
                before = targets[i][1];
            }
        }
        return answer;
    }
}
