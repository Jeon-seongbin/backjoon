package com.leetcode.midium;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfClosedIslands1254 {
    public static void main(String[] args) {
        NumberOfClosedIslands1254 a = new NumberOfClosedIslands1254();

        a.closedIsland(new int[][]{

                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}
        });
    }

    class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int closedIsland(int[][] grid) {
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int count = 0;

        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    boolean isOut = false;
                    if (!isVisited[i][j]) {
                        count++;
                        isVisited[i][j] = true;
                        queue.add(new Point(i, j));

                        while (!queue.isEmpty()) {
                            Point now = queue.poll();

                            for (int x = 0; x < 4; x++) {
                                int nextX = now.x + dx[x];
                                int nextY = now.y + dy[x];

                                if (nextX < 0 || grid.length <= nextX || nextY < 0 || grid[0].length <= nextY) {
                                    isOut = true;
                                    continue;
                                }
                                if (grid[nextX][nextY] == 1 || isVisited[nextX][nextY]) {
                                    continue;
                                }
                                queue.add(new Point(nextX, nextY));
                                isVisited[nextX][nextY] = true;
                            }

                        }
                        if (isOut) {
                            count--;
                        }
                    }

                }
            }
        }
        return count;
    }

}
