package com.leetcode.midium;


import java.util.LinkedList;
import java.util.Queue;

public class Matrix01_542 {

    public static int[][] updateMatrix(int[][] mat) {
        int height = mat.length;
        int width = mat[0].length;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<Point> q = new LinkedList<>();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Point(i, j, 0));
                    continue;
                }
                mat[i][j] = -1;
            }
        }

        while (!q.isEmpty()) {
            Point nowPoint = q.poll();
            for (int i = 0; i < 4; i++) {
                int newX = nowPoint.x + dx[i];
                int newY = nowPoint.y + dy[i];

                if (newX < 0 || height <= newX || newY < 0 || width <= newY || mat[newX][newY] != -1) {
                    continue;
                }

                q.add(new Point(newX, newY, nowPoint.level + 1));
                mat[newX][newY] = nowPoint.level + 1;
            }
        }

        return mat;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{1, 0, 1, 1, 0, 0, 1, 0, 0, 1}, {0, 1, 1, 0, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 0, 0, 1, 0, 0}, {1, 0, 1, 0, 1, 1, 1, 1, 1, 1}, {0, 1, 0, 1, 1, 0, 0, 0, 0, 1}, {0, 0, 1, 0, 1, 1, 1, 0, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 0, 1, 1}, {1, 0, 0, 0, 1, 1, 1, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0, 1, 0}, {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}};
        updateMatrix(input);
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

