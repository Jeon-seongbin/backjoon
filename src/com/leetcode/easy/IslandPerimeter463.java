package com.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class IslandPerimeter463 {
    public static void main(String[] args) {
        islandPerimeter(new int[][]

                {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}}
        );
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean[][] isVisited;

    static class Point463 {
        int x;
        int y;

        int cango;

        Point463(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static public int islandPerimeter(int[][] grid) {
        int result = 0;
        isVisited = new boolean[grid.length][grid[0].length];
        Queue<Point463> q = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (1 == grid[i][j] && isVisited[i][j] == false) {
                    q.add(new Point463(i, j));


                    while (!q.isEmpty()) {
                        Point463 now = q.poll();

                        int count = 0;
                        for (int z = 0; z < 4; z++) {
                            int newX = now.x + dx[z];
                            int newY = now.y + dy[z];

                            if (newX < 0 || grid.length <= newX || newY < 0 || grid[0].length <= newY) {
                                continue;
                            }

                            if (isVisited[newX][newY]) {
                                continue;
                            }
                            if(grid[newX][newY] == 0){
                                continue;
                            }
                            isVisited[newX][newY] = true;
                            count++;
                            q.add(new Point463(newX, newY));
                        }
                        if (count == 1) {
                            result += 3;
                        }

                        if (count == 2) {
                            result += 2;
                        }

                        if (count == 3) {
                            result += 1;
                        }

                    }
                }
            }
        }
        return result;
    }
}
