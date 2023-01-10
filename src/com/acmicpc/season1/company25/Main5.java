package com.acmicpc.season1.company25;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main5 {

    // 첫째 줄에 N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 1,000), K(1 ≤ K ≤ 10)이 주어진다.
    public static int N, M, K;

    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static int map[][];
    public static boolean isVisited[][][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        isVisited = new boolean[N][M][K + 1];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt("" + temp.charAt(j));
//                isVisited[i][j] = Integer.MAX_VALUE;
//                if (map[i][j] == 1) {
//                    isVisited[i][j] = true;
//                }
            }
        }
        int result = bfs();
        bw.write("" + result);
        bw.flush();
        bw.close();
        br.close();
    }

    public static int bfs() {
        Queue<Point14442> q = new LinkedList<>();
        q.offer(new Point14442(0, 0, 1, 0));
        isVisited[0][0][0] = true;
        while (!q.isEmpty()) {

            Point14442 now = q.poll();
            if (now.x == N - 1 && now.y == M - 1) {
                return now.count;
            }

            for (int i = 0; i < 4; i++) {

                int newX = now.x + dx[i];
                int newY = now.y + dy[i];

                if (newX < 0 || N <= newX || newY < 0 || M <= newY) {
                    continue;
                }

                if(map[newX][newY] == 0 && !isVisited[newX][newY][now.k]){
                    isVisited[newX][newY][now.k] = true;
                    q.offer(new Point14442(newX, newY, now.count + 1 , now.k));
                }else{
                    if(map[newX][newY] == 1 && now.k < K && !isVisited[newX][newY][now.k + 1]){
                        isVisited[newX][newY][now.k + 1] = true;
                        q.offer(new Point14442(newX, newY, now.count + 1 , now.k + 1));
                    }
                }

            }
        }
        return -1;
    }
}

class Point14442 {
    int x;
    int y;
    int count;
    int k;

    Point14442(int x, int y, int count, int k) {
        this.x = x;
        this.y = y;
        this.count = count;
        this.k = k;

    }
}
