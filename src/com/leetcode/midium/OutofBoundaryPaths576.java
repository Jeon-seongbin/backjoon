package com.leetcode.midium;

import java.util.LinkedList;
import java.util.Queue;

public class OutofBoundaryPaths576 {
    public static void main(String[] args) {
        int result = findPaths(2, 2, 2, 0, 0);
        System.out.println(result);
    }

    public static Integer[][][] dp;
    public static int mod = 1_000_000_000 + 7;

    public static int M;
    public static int N;

    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new Integer[m][n][maxMove + 1];
        M = m;
        N = n;
        return helper(maxMove, startRow, startColumn);
    }

    public static int helper(int maxMove, int startRaw, int startColumn) {
        if (startRaw < 0 || startColumn < 0 || M <= startRaw || N <= startColumn) {
            return 1;
        }
        if (maxMove <= 0) {
            return 0;
        }
        if (dp[startRaw][startColumn][maxMove] != null) {
            return dp[startRaw][startColumn][maxMove];
        }

        int res = 0;

        res = (res+ helper(maxMove +1 , startRaw  , startColumn)) % mod;
        res = (res+ helper(maxMove -1 , startRaw  , startColumn)) % mod;
        res = (res+ helper(maxMove  ,  startRaw + 1  , startColumn)) % mod;
        res = (res+ helper(maxMove  , startRaw -1  , startColumn)) % mod;

        dp[startRaw][startColumn][maxMove]=res;
        return res;
    }


    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static int count = 0;

    public static class Point576 {
        Point576(int x, int y, int moveCount) {
            this.x = x;
            this.y = y;
            this.moveCount = moveCount;
        }

        int x;
        int y;
        int moveCount;
    }

    public static int findPaths1(int m, int n, int maxMove, int startRow, int startColumn) {

        Queue<Point576> queue = new LinkedList<>();
        queue.add(new Point576(startRow, startColumn, 1));

        while (!queue.isEmpty()) {
            Point576 nowPoint = queue.poll();
            if (maxMove < nowPoint.moveCount) {
                break;
            }
            for (int i = 0; i < 4; i++) {
                int newX = dx[i] + nowPoint.x;
                int newY = dy[i] + nowPoint.y;

                if (newX < 0 || newY < 0 || m <= newX || n <= newY) {
                    count++;
                }
            }
            for (int i = 0; i < 4; i++) {
                int newX = dx[i] + nowPoint.x;
                int newY = dy[i] + nowPoint.y;

                if (newX < 0 || newY < 0 || m <= newX || n <= newY) {
                    continue;
                }
                queue.add(new Point576(newX, newY, nowPoint.moveCount + 1));
            }


        }
        return count;
    }
}
