package com.programmers.level2;

import java.util.Arrays;

public class PatriotMissile {
    public static void main(String[] args) {

        solution(new int[][]{
                {0, 1},
                {5, 4},
                {1, 4},
                {2, 3},
        });
    }

    public static int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (o1, o2) -> (o1[1] - o2[1]));
        int kijun = 0;
        for (int i = 0; i < targets.length; i++) {
            if (kijun <= targets[i][0]) {
                answer++;
                kijun = targets[i][1];
            }
        }
        return answer;
    }
}
