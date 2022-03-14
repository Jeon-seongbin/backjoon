package com.company20;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main5 {
    public static int height;
    public static int max;
    public static int[][] map;
    public static boolean[][] visit;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static int zoneCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // input
        height = Integer.parseInt(st.nextToken());
        map = new int[height][height];
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < height; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (max < map[i][j]) {
                    max = map[i][j];
                }
            }
        }

        int answer = 0;
        for (int i = 0; i <= max; i++) {

            visit = new boolean[height][height];
            zoneCount = 0;
            bfs(i);
            answer = Math.max(answer, zoneCount);
        }

        bw.write("" + answer);
        bw.flush();
        br.close();
        bw.close();
    }

    public static void bfs(int he) {

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height; j++) {
                // 높이보다 낮은곳 제외
                if (map[i][j] <= he) {
                    continue;
                }
                // 방문 한 곳은 제외
                if (visit[i][j]) {
                    continue;
                }

                Queue<Point5> queue = new LinkedList<>();

                queue.add(new Point5(i, j));
                visit[i][j] = true;
                zoneCount++;
                while (!queue.isEmpty()) {
                    Point5 q = queue.poll();
                    for (int z = 0; z < 4; z++) {
                        int newI = q.x + dx[z];
                        int newJ = q.y + dy[z];

                        // 옆으로 간 곳이 범위를 넘어가면 제외
                        if (newI < 0 || height <= newI || newJ < 0 || height <= newJ) {
                            continue;
                        }
                        // 높이보다 낮은곳 제외
                        if (map[newI][newJ] <= he) {
                            continue;
                        }
                        // 방문 한 곳이면 제외
                        if (visit[newI][newJ]) {
                            continue;
                        }
                        queue.add(new Point5(newI, newJ));
                        visit[newI][newJ] = true;
                    }
                }
            }
        }
    }
}

class Point5 {
    int x;
    int y;

    Point5(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
