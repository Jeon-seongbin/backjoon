package com.leetcode.midium;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands200 {
    public static void main(String[] args) {

    }

    public int numIslands(char[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        boolean[][] isVisited = new boolean[height][width];
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};


        int result = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (!isVisited[i][j] && grid[i][j] == '1') {
                    result++;
                    Queue<Point200> q = new LinkedList<>();
                    isVisited[i][j] = true;
                    q.add(new Point200(i, j));

                    while (!q.isEmpty()) {
                        Point200 now = q.poll();

                        for (int ne = 0; ne < 4; ne++) {
                            int nextX = now.x + dx[ne];
                            int nextY = now.y + dy[ne];

                            if (nextX < 0 || height <= nextX || nextY < 0 || width <= nextY) {
                                continue;
                            }
                            if (isVisited[nextX][nextY]) {
                                continue;
                            }
                            if (grid[nextX][nextY] == '0') {
                                continue;
                            }
                            isVisited[nextX][nextY] = true;
                            q.add(new Point200(nextX, nextY));


                        }
                    }
                }
            }
        }

        return result;
    }
}


class Point200 {
    int x;
    int y;

    Point200(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
