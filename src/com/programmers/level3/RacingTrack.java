package com.programmers.level3;

import java.util.LinkedList;
import java.util.Queue;

public class RacingTrack {
    public static void main(String[] args) {
        solution(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}});
    }

    private static final int[] dx = new int[]{1, 0, -1, 0};
    private static final int[] dy = new int[]{0, 1, 0, -1};

    private static int lastCost = Integer.MAX_VALUE;

    private static int n;
    private static boolean[][] visited;
    private static int[][] map;


    static class Road {
        int x;
        int y;

        int destination; // 방향 정보
        int cost;

        Road(int x, int y, int destination, int cost) {
            this.x = x;
            this.y = y;
            this.destination = destination;
            this.cost = cost;
        }
    }


    public static int solution(int[][] board) {
        n = board.length;
        map = board;
        visited = new boolean[n][n];

        bfs(-1, 0);
        return lastCost;
    }

    public static void bfs(int dir, int cost) {
        visited[0][0] = true;
        Queue<Road> q = new LinkedList<>();
        q.add(new Road(0, 0, dir, cost));

        while (!q.isEmpty()) {
            Road nowRoad = q.poll();

            int nowPointX = nowRoad.x;
            int nowPointY = nowRoad.y;
            int nowCost = nowRoad.cost;
            int nowDestination = nowRoad.destination;

            // bfs를 돌 때 , 마지막 자리일떄 확인
            if (nowPointX == n - 1 && nowPointY == n - 1) {
                lastCost = Math.min(nowCost, lastCost);
            }

            for (int i = 0; i < 4; i++) {
                int nextX = dx[i] + nowPointX;
                int nextY = dy[i] + nowPointY;
                int newCost = nowCost;

                if (nextX < 0 || n <= nextX || nextY < 0 || n <= nextY || map[nextX][nextY] == 1) {
                    continue;
                }
  
                if (nowDestination == -1) {
                    newCost += 100;
                } else if (nowDestination == i) {
                    newCost += 100;
                } else {
                    newCost += 600;
                }

                if (map[nextX][nextY] >= newCost) {
                    visited[nextX][nextY] = true;
                    q.add(new Road(nextX, nextY, i, newCost));
                    map[nextX][nextY] = newCost;
                }


            }

        }
    }


}
