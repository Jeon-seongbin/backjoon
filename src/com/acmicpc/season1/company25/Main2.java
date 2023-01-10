package com.acmicpc.season1.company25;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
    public static int N, M;

    public static int map[][];
    public static int isVisited[][];

    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 첫째 줄에 N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 1,000)
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        isVisited = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = input[j] - '0';
                isVisited[i][j] = Integer.MAX_VALUE;
            }
        }

        int result = bfs();
        bw.write("" + result);
        bw.flush();
        bw.close();
        br.close();

    }

    public static int bfs() {
        Queue<Point2206> q = new LinkedList<>();
        q.add(new Point2206(0, 0, 0, 0));
        isVisited[0][0] = 0;
        while (!q.isEmpty()) {
            Point2206 currentPoint = q.poll();
            if (currentPoint.x == N - 1 && currentPoint.y == M - 1) {
                return currentPoint.count + 1;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = currentPoint.x + dx[i];
                int nextY = currentPoint.y + dy[i];
                if (nextX < 0 || N <= nextX || M <= nextY || nextY < 0) {
                    continue;
                }

                // 방문 한 횟수               <=   드릴로 판 횟수
                if (isVisited[nextX][nextY] <= currentPoint.brokenWallCount) continue;
                // 조건이 <= 이기 때문에 방문 한 곳이라면 뛰어넘는다 라는게 된다

                if (map[nextX][nextY] == 0) {
                    isVisited[nextX][nextY] = currentPoint.brokenWallCount;
                    // 방문 한 곳이라고 친다

                    q.add(new Point2206(nextX, nextY, currentPoint.count + 1, currentPoint.brokenWallCount));
                } else {
                    if (currentPoint.brokenWallCount == 0) {
                        isVisited[nextX][nextY] = currentPoint.brokenWallCount + 1;
                        // 방문 한 곳이라고 친다

                        q.add(new Point2206(nextX, nextY, currentPoint.count + 1, currentPoint.brokenWallCount + 1));
                    }
                }
            }
        }
        return -1;
    }

}

class Point2206 {
    Point2206(int x, int y, int count, int brokenWallCount) {
        this.x = x;
        this.y = y;
        this.count = count;
        this.brokenWallCount = brokenWallCount;
    }
    int x;
    int y;
    int count;
    int brokenWallCount;
}
