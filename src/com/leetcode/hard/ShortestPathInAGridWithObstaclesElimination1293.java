package com.leetcode.hard;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInAGridWithObstaclesElimination1293 {
    public static void main(String[] args) {
//        System.out.println(shortestPath(new int[][]{{0, 0, 0}, {1, 1, 0}, {0, 0, 0}, {0, 1, 1}, {0, 0, 0}}, 1));
//        System.out.println(shortestPath(new int[][]{{0}}, 1));
//        System.out.println(shortestPath(new int[][]{{0, 0}, {1, 0}, {1, 0}, {1, 0}, {1, 0}, {1, 0}, {0, 0}, {0, 1}, {0, 1}, {0, 1}, {0, 0}, {1, 0}, {1, 0}, {0, 0}}, 4));
        System.out.println(shortestPath(new int[][]{{0, 0, 0}}, 1));

    }


    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static int shortestPath(int[][] grid, int k) {

        int height = grid.length;
        int width = grid[0].length;


        if (height == 1 && width == 1) {
            return 0;
        }

        int[][][] newGrid = new int[k + 1][height][width];
        boolean[][][] isVisited = new boolean[k + 1][height][width];

        for (int ii = 0; ii < k + 1; ii++) {
            for (int jj = 0; jj < height; jj++) {
                for (int xx = 0; xx < width; xx++) {
                    newGrid[ii][jj][xx] = Integer.MAX_VALUE;
                    isVisited[ii][jj][xx] = false;
                }
            }
        }


        Queue<Point1293> queue = new LinkedList<>();

        queue.add(new Point1293(0, 0, 0, k));

        while (!queue.isEmpty()) {
            Point1293 nowPoint = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = dx[i] + nowPoint.x;
                int nextY = dy[i] + nowPoint.y;

                if (0 <= nextX && nextX < height && 0 <= nextY && nextY < width) {
                    if (grid[nextX][nextY] == 1 && 1 <= nowPoint.eliminateCount && !isVisited[nowPoint.eliminateCount - 1][nextX][nextY]) {
                        queue.add(
                                new Point1293(
                                        nextX,
                                        nextY,
                                        nowPoint.moveCount + 1,
                                        nowPoint.eliminateCount - 1));

                        isVisited[nowPoint.eliminateCount - 1][nextX][nextY] = true;
                        newGrid[nowPoint.eliminateCount - 1][nextX][nextY] = nowPoint.moveCount + 1;

                    } else if (grid[nextX][nextY] == 0 && !isVisited[nowPoint.eliminateCount][nextX][nextY]) {
                        queue.add(
                                new Point1293(
                                        nextX,
                                        nextY,
                                        nowPoint.moveCount + 1,
                                        nowPoint.eliminateCount));

                        isVisited[nowPoint.eliminateCount][nextX][nextY] = true;
                        newGrid[nowPoint.eliminateCount][nextX][nextY] = nowPoint.moveCount + 1;
                    }
                    if (nextX == height - 1 && nextY == width - 1) {
                        int min = Integer.MAX_VALUE;

                        for (int ii = 0; ii < k + 1; ii++) {
                            min = Math.min(min, newGrid[ii][nextX][nextY]);
                        }
                        return min;
                    }
                }
            }

        }

        return -1;
    }

}

class Point1293 {
    int x;
    int y;
    int moveCount;
    int eliminateCount;

    Point1293(int x, int y, int moveCount, int eliminateCount) {
        this.x = x;
        this.y = y;
        this.moveCount = moveCount;
        this.eliminateCount = eliminateCount;
    }
}