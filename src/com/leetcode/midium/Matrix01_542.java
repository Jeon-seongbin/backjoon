package com.leetcode.midium;


import java.util.LinkedList;
import java.util.Queue;

public class Matrix01_542 {

    public static void main(String[] args) {
        int[][] input = new int[][]{{1, 0, 1, 1, 0, 0, 1, 0, 0, 1}, {0, 1, 1, 0, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 0, 0, 1, 0, 0}, {1, 0, 1, 0, 1, 1, 1, 1, 1, 1}, {0, 1, 0, 1, 1, 0, 0, 0, 0, 1}, {0, 0, 1, 0, 1, 1, 1, 0, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 0, 1, 1}, {1, 0, 0, 0, 1, 1, 1, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0, 1, 0}, {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}};
        updateMatrix(input);
    }

    public static int[][] updateMatrix(int[][] mat) {
        Queue<Point> queue = new LinkedList<>();

        int height = mat.length;
        int width = mat[0].length;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (mat[i][j] == 0) { // We will check 0 side
                    queue.add(new Point(i, j, 0));
                } else {
                    mat[i][j] = -1; // -1 not changed (1 will change to -1)

                }
            }
        }

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = now.x + dx[i];
                int newY = now.y + dy[i];
                if (newX < 0 || height <= newX || newY < 0 || width <= newY || mat[newX][newY] != -1) {
                    // if changed
                    continue;
                }
                mat[newX][newY] = now.level + 1; // change level
                queue.add(new Point(newX, newY, now.level + 1)); // add queue for check next -1 inside level
            }
        }

        return mat;
    }
/*
// TLE


    public int[][] updateMatrix(int[][] mat) {

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int height = mat.length;
        int width = mat[0].length;
        int[][] result = new int[height][width];


        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (mat[i][j] == 0) {
                    continue;
                }

                Queue<Point> queue = new LinkedList<>();
                queue.add(new Point(i, j, 0));

                while (!queue.isEmpty()) {

                    Point nowPoint = queue.poll();

                    for (int fourDxdy = 0; fourDxdy < 4; fourDxdy++) {
                        int newX = dx[fourDxdy] + nowPoint.x;
                        int newY = dy[fourDxdy] + nowPoint.y;

                        if (newX < 0 || height <= newX || newY < 0 || width <= newY) {
                            continue;
                        }

                        if (mat[newX][newY] == 0) {
                            result[i][j] = nowPoint.count + 1;
                            queue = new LinkedList<>();
                            break;
                        }


                        queue.offer(new Point(newX, newY, nowPoint.count + 1));


                    }

                }
            }
        }
        return result;

    }

*/
}

class Point {
    public Point(int x, int y, int level) {
        this.x = x;
        this.y = y;
        this.level = level;
    }

    int x;
    int y;
    int level;
}

