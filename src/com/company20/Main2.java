package com.company20;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {

    public static int N = 0;
    public static int M = 0;
    public static int[][] map;

    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static Queue<Point1> queue = new LinkedList<>();

    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // M,N이 주어진다. N은 상자의 가로 칸의 수, M은 상자의 세로 칸의 수
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    Point1 point1 = new Point1(i, j);
                    queue.add(point1);
                }
            }
        }
        bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (map[i][j] == 0) {
                    count = 0;
                    break;
                }
                if (count < map[i][j]) {
                    count = map[i][j];
                }
            }
            if (count == 0) {
                break;
            }
        }
        bw.write("" + (count - 1));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            Point1 p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = p.x + dx[i];
                int newY = p.y + dy[i];
                // M,N이 주어진다. N은 상자의 가로 칸의 수, M은 상자의 세로 칸의 수
                if (0 <= newX && newX < N && 0 <= newY && newY < M) {
                    if (map[newX][newY] == -1 || 1 <= map[newX][newY]) {
                        continue;
                    }
                    queue.add(new Point1(newX, newY));
                    map[newX][newY] = map[p.x][p.y] + 1;
                }
            }
        }
    }
}

class Point1 {
    int x;
    int y;

    Point1(int x, int y) {
        this.x = x;
        this.y = y;
    }
}