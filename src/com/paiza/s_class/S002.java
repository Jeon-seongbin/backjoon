package com.paiza.s_class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S002 {
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int N, M;
    public static String[][] map;
    public static boolean[][] isVisited;
    public static PointS002 endPoint;
    public static Queue<PointS002> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new String[N][M];
        isVisited = new boolean[N][M];
        queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = st.nextToken();
                if (map[i][j].equals("s")) {
                    queue.offer(new PointS002(i, j, 0));
                } else if (map[i][j].equals("1")) {
                    isVisited[i][j] = true;
                } else if (map[i][j].equals("g")) {
                    endPoint = new PointS002(i, j, 0);
                }
            }
        }

        System.out.println(bfs());
    }

    public static String bfs() {

        while (!queue.isEmpty()) {
            PointS002 now = queue.poll();
            isVisited[now.x][now.y] = true;

            for (int i = 0; i < 4; i++) {
                int newX = now.x + dx[i];
                int newY = now.y + dy[i];

                if (newX == endPoint.x && newY == endPoint.y) {
                    return "" + ( now.point + 1);
                }
                if (newX < 0 || N <= newX || newY < 0 || M <= newY) {
                    continue;
                }
                if (isVisited[newX][newY]) {
                    continue;
                }
                isVisited[newX][newY] = true;
                queue.add(new PointS002(newX, newY, now.point + 1));


            }
        }


        return "Fail";
    }
}

class PointS002 {
    int x;
    int y;

    int point;

    PointS002(int x, int y, int point) {
        this.x = x;
        this.y = y;
        this.point = point;
    }
}
