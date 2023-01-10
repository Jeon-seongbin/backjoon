package com.acmicpc.season1.package15;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;
    static int N, M;
    static char[][] map;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    static class Point {
        int r, c, cnt;

        public Point(int r, int c, int cnt) {
            super();
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }

        public Point(int r, int c) {
            super();
            this.r = r;
            this.c = c;
        }

    }

    static Point me;
    static Point start;
    static Queue<Point> q;
    static Queue<Point> fq;

    public static void main(String[] args) throws IOException {

        q = new LinkedList<>();
        fq = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];


        for (int i = 0; i < N; i++) {
            String userInputs = br.readLine();
            for (int j = 0; j < M; j++) {
                char userInput = userInputs.charAt(j);
                map[i][j] = userInput;
                if (userInput == 'F') {
                    fq.add(new Point(i, j));
                }
                if (userInput == 'J') {
                    q.add(new Point(i, j));
                }
            }
        }
        int result = bfs();
        if(result == -1) System.out.println("IMPOSSIBLE");
        else System.out.println(result);

    }

    private static int bfs() {
        while (!q.isEmpty()) {
            int fsize = fq.size();
            for (int k = 0; k < fsize; k++) {
                Point fire = fq.poll();
                for (int i = 0; i < 4; i++) {
                    int nr = fire.r + dr[i];
                    int nc = fire.c + dc[i];
                    if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                        continue;
                    }
                    if (map[nr][nc] == '#' || map[nr][nc] == 'F') {
                        continue;
                    }
                    map[nr][nc] = 'F';
                    fq.offer(new Point(nr, nc, fire.cnt + 1));

                }
            }

            int qSize = q.size();
            for (int k = 0; k < qSize; k++) {
                Point cur = q.poll();

                for (int i = 0; i < 4; i++) {
                    int nr = cur.r + dr[i];
                    int nc = cur.c + dc[i];
                    if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                        return cur.cnt + 1;
                    }
                    if (map[nr][nc] == '#' || map[nr][nc] == 'F' || map[nr][nc] == 'J') {
                        continue;
                    }
                    map[nr][nc] = 'J';
                    q.offer(new Point(nr, nc, cur.cnt + 1));
                }
            }
        }
        return -1;
    }
}