package com.programmers.level2;

public class Dungeon {

    public static void main(String[] args) {
        solution(80, new int[][]{
                {80, 20},
                {50, 40},
                {30, 10},
        });
    }


    public static int answer = 0;

    public static int solution(int k, int[][] dungeons) {
        boolean[] isVisited = new boolean[dungeons.length];
        dfs(dungeons, isVisited, k, 0);
        return answer;
    }

    public static void dfs(int[][] dungeons, boolean[] isVisited, int pirodo, int count) {

        for (int i = 0; i < dungeons.length; i++) {
            if (isVisited[i]) {
                continue;
            }
            if (pirodo < dungeons[i][0]) {
                continue;
            }

            isVisited[i] = true;
            dfs(dungeons, isVisited, pirodo - dungeons[i][1], count + 1);
            isVisited[i] = false;
        }

        answer = Math.max(count, answer);
    }
}
