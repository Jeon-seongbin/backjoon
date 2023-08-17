package com.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class EscapeMaze {
    public static void main(String[] args) {
        solution(new String[]{"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"});
    }


    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};


    static class Point {
        int x;
        int y;
        int count;

        Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static int solution(String[] maps) {

        int height = maps.length;
        int width = maps[0].length();

        int startX = 0;
        int startY = 0;
        int leverX = 0;
        int leverY = 0;

        for (int i = 0; i < height; i++) {

            char[] m = maps[i].toCharArray();
            for (int j = 0; j < width; j++) {
                char mm = m[j];
                if (mm == 'S') {
                    startX = i;
                    startY = j;
                }

                if (mm == 'L') {
                    leverX = i;
                    leverY = j;

                }


            }
        }

        int endCount = bfs(startX, startY, maps, 'L');
        int leverCount = bfs(leverX, leverY, maps, 'E');

        if (endCount == -1 || leverCount == -1) {
            return -1;
        }
        return endCount + leverCount;

    }

    public static int bfs(int pointX, int pointY, String[] maps, char target) {


        int height = maps.length;
        int width = maps[0].length();

        boolean[][] isVisited = new boolean[maps.length][maps[0].length()];

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(pointX, pointY, 0));
        while (!queue.isEmpty()) {

            Point nowPoint = queue.poll();
            isVisited[nowPoint.x][nowPoint.y] = true;
            for (int i = 0; i < 4; i++) {
                int newX = nowPoint.x + dx[i];
                int newY = nowPoint.y + dy[i];


                if (newX < 0 || height <= newX || newY < 0 || width <= newY) {
                    continue;
                }

                if (maps[newX].charAt(newY) == 'X') {
                    continue;
                }
                if (isVisited[newX][newY]) {
                    continue;
                }

                if (maps[newX].charAt(newY) == target) {
                    return nowPoint.count + 1;
                }

                queue.add(new Point(newX, newY, nowPoint.count + 1));
                isVisited[newX][newY] = true;
            }
        }

        return -1;
    }
}
