package com.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill733 {
    public static void main(String[] args) {

    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int height = image.length;
        int width = image[0].length;

        boolean[][] isVisited = new boolean[height][width];
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        Queue<Point733> queue = new LinkedList<>();

        queue.add(new Point733(sr, sc));
        isVisited[sr][sc] = true;

        int targetImageColor = image[sr][sc];
        image[sr][sc] = color;
        while (!queue.isEmpty()) {
            Point733 now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];


                if (nextX < 0 || height <= nextX || nextY < 0 || width <= nextY) {
                    continue;
                }
                if (isVisited[nextX][nextY]) {
                    continue;
                }
                if (image[nextX][nextY] != targetImageColor) {
                    continue;
                }

                image[nextX][nextY] = color;
                isVisited[nextX][nextY] = true;
                queue.add(new Point733(nextX, nextY));
            }
        }

        return image;
    }
}

class Point733 {
    int x;
    int y;

    Point733(int x, int y) {
        this.x = x;
        this.y = y;
    }
}