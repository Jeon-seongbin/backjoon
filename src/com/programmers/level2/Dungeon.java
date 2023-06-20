package com.programmers.level2;

public class Dungeon {

    public static void main(String[] args) {
        solution(80, new int[][]{
                {80, 20},
                {50, 40},
                {30, 10},
        });
    }

    public static int solution(int k, int[][] dungeons) {
        int answer = -1;

        boolean[] isVisited = new boolean[dungeons.length];
        answer = sol(k, dungeons, isVisited, 0, answer);

        return answer;
    }


    public static int sol(int k, int[][] dungeons, boolean[] isVisited, int count, int answer) {

        for (int i = 0; i < dungeons.length; i++) {
            if (!isVisited[i] && dungeons[i][0] <= k) {
                isVisited[i] = true;
                answer = sol(k - dungeons[i][1], dungeons, isVisited, count + 1, answer);
                isVisited[i] = false;
            }
        }
        return Math.max(answer, count);
    }
}
