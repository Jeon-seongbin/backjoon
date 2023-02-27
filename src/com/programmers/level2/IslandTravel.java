package com.programmers.level2;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/154540
public class IslandTravel {
    public static void main(String[] args) {
        solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"});
    }

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int[] solution(String[] maps) {

        int[] dx = {1, 0, -1, 0};

        int[] dy = {0, 1, 0, -1};
        boolean[][] isVisited = new boolean[maps.length][maps[0].length()];

        int height = maps.length;
        int width = maps[0].length();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                char m = maps[i].charAt(j);

                if (m == 'X') {
                    isVisited[i][j] = true;
                }
            }
        }

        Queue<Pair> queue = new LinkedList<>();


        ArrayList<Integer> a = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                char m = maps[i].charAt(j);

                if (m != 'X' && !isVisited[i][j]) {
                    int temp = 0;
                    queue.add(new Pair(i, j));

                    int t = Integer.parseInt("" + maps[i].charAt(j));
                    isVisited[i][j] = true;
                    while (!queue.isEmpty()) {

                        Pair now = queue.poll();

                        for (int x = 0; x < 4; x++) {
                            int nextX = now.x + dx[x];
                            int nextY = now.y + dy[x];

                            if (nextX < 0 || height <= nextX || nextY < 0 || width <= nextY) {
                                continue;
                            }
                            if (isVisited[nextX][nextY]) {
                                continue;
                            }

                            isVisited[nextX][nextY] = true;
                            queue.add(new Pair(nextX, nextY));
                            t += Integer.parseInt("" + maps[nextX].charAt(nextY));
                        }
                    }
                    temp += t;
                    a.add(temp);

                }
            }
        }

        if (a.size() == 0) {
            int[] answer1 = new int[1];
            answer1[0] = -1;
            return answer1;
        }

        Collections.sort(a);
        int[] answer = new int[a.size()];

        for (int i = 0; i < a.size(); i++) {
            answer[i] = a.get(i);
        }

        return answer;
    }
}
