package com.acmicpc.season1.company25;

import java.io.*;
import java.util.*;

public class Main4 {
    public static int M, N, K;
    public static int map[][];
    public static boolean isVisited[][];
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // M, N, K는 모두 100 이하의 자연수이다
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        isVisited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int ii = 0; ii < N; ii++) {
                for (int jj = 0; jj < M; jj++) {
                    if (x1 <= ii && ii < x2 && y1 <= jj && jj < y2) {
                        isVisited[jj][ii] = true;
                        map[jj][ii] = 1;

                    }
                }
            }
        }
        int count = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisited[i][j]) {
                    count++;
                    arrayList.add(bfs(i, j));

                }
            }
        }

        Collections.sort(arrayList);
        bw.write("" + count+ "\n");
        for(int i =0 ; i < arrayList.size();i++){
            bw.write("" + arrayList.get(i));
            bw.write(" " );

        }
        bw.flush();
        br.close();
        bw.close();

    }

    public static int bfs(int x, int y) {
        int count = 0;

        Queue<Point2583> q = new LinkedList<>();
        q.add(new Point2583(x, y));

        while (!q.isEmpty()) {
            Point2583 now = q.poll();
            count++;
            isVisited[now.x][now.y] = true;

            for (int i = 0; i < 4; i++) {

                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if (nextX < 0 || M <= nextX || nextY < 0 || N <= nextY) {
                    continue;
                }
                if (isVisited[nextX][nextY]) {
                    continue;
                }
                isVisited[nextX][nextY] = true;
                q.add(new Point2583(nextX, nextY));
            }
        }
        return count;
    }
}

class Point2583 {
    int x;
    int y;

    Point2583(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
