package com.acmicpc.season1.package16;

import java.io.*;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2573
public class Main6 {

    static int[][] map;
    static int[][] melt;
    static boolean[][] visit;

    static int row;
    static int col;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        map = new int[row][col];
        melt = new int[row][col];
        visit = new boolean[row][col];

        // input
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solution();
        br.close();
    }

    static void solution() {
        int year = 0;

        while (true) {
            int count = 0;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (!visit[i][j] && map[i][j] != 0) {
                        dfs(i, j);
                        count++;
                    }
                }
            }

            if (count == 0) {
                System.out.println(0);
                break;
            }

            if (2 <= count) {
                System.out.println(year);
                break;
            }
            melting();
            year++;
        }
    }

    static void dfs(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < row && 0 <= ny && ny < col) {
                if (map[nx][ny] == 0) {
                    melt[x][y]++;
                }
                if (!visit[nx][ny] && map[nx][ny] != 0) {
                    dfs(nx, ny);
                }
            }
        }
    }

    static void melting() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map[i][j] -= melt[i][j];
                if (map[i][j] < 0) {
                    map[i][j] = 0;
                }
                visit[i][j] = false;
                melt[i][j] = 0;
            }
        }
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
