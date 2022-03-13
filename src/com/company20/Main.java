package com.company20;

import java.io.*;
import java.util.ArrayList;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static ArrayList<Point>[][] switchs;
    public static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, -1, 0, 1};
    public static int N;
    public static int M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][N];
        switchs = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                switchs[i][j] = new ArrayList<>();
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1;
            switchs[a][b].add(new Point(c, d));
            // 여기가 포인트
        }
        bw.write("" + bfs());
        bw.flush();
    }

    public static int bfs() {
        int cnt = 1;
        boolean[][] visited = new boolean[N][N];
        boolean[][] isLight = new boolean[N][N];

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));
        isLight[0][0] = true;
        visited[0][0] = true;

        /*
        (0, 0)부터 출발해서 스위치가 있는 방이라면 스위치를 눌러볼 것인데,
        해당 방에 불이 꺼져 있다면 스위치로 불을 켜준다.
        새로운 방에 불이 켜졌다면 (0, 0)부터 다시 탐색을 시도하는 방법이었다.
        (0, 0)부터 다시 탐색을 시도했던 이유는
        ex. (0, 0)에서 이동할 수 없었던 방을 다시 이동할 수 있게 되는 경우가 있었기 때문이다.
        하지만 visited 배열을 계속 다시 생성해주어야 했기 때문에
        메모리와 시간이 굉장히 비효율적이었다..
         */
        while (!q.isEmpty()) {
            Point now = q.poll();

            // 스위치가 있다면 불을 켜보자.
            // 스위치 리스트가 있으면?
            if (switchs[now.r][now.c].size() > 0) {
                boolean flag = false;
                for (Point p : switchs[now.r][now.c]) {
                    if (!isLight[p.r][p.c]) {
                        isLight[p.r][p.c] = true;
                        cnt++;
                        flag = true;
                    }
                }

                if (flag) {
                    q.clear();
                    q.add(new Point(0, 0));
                    visited = new boolean[N][N];
                    visited[0][0] = true;
                    continue;
                }
            }
            for (int d = 0; d < 4; d++) {
                int rr = now.r + dr[d];
                int cc = now.c + dc[d];

                if (rr < 0 || cc < 0 || N <= rr || N <= cc) {
                    continue;
                }

                //불이 꺼져있는 경우(불이 켜져있는 경우만 통과)
                if (visited[rr][cc] || !isLight[rr][cc]) {
                    continue;
                }
                visited[rr][cc] = true;
                q.add(new Point(rr, cc));
            }
        }
        return cnt;
    }
}

class Point {
    int r;
    int c;

    Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
