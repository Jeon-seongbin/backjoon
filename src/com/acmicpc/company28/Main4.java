package com.acmicpc.company28;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main4 {
    public static int N, M;
    public static boolean[][] isVisited;
    public static String[][] map;

    public static Queue<PointA055> queue;

    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        isVisited = new boolean[N][M];
        map = new String[N][M];

        queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                String input = "" + temp.charAt(j);

                if (input.equals("#")) {
                    isVisited[i][j] = true;
                }
                if (input.equals("S")) {
                    queue.add(new PointA055(i, j));
                    isVisited[i][j] = true;
                }
                map[i][j] = input;
            }
        }
        boolean result = bfs();
        if (result) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean bfs() {
        while (!queue.isEmpty()) {
            PointA055 nowPoint = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newX = nowPoint.x + dx[i];
                int newY = nowPoint.y + dy[i];

                if (newX < 0 || N <= newX || newY < 0 || M <= newY) {
                    return true;
                }
                if (isVisited[newX][newY]) {
                    continue;
                }

                queue.add(new PointA055(newX, newY));
                isVisited[newX][newY] = true;
            }
        }
        return false;
    }
}

class PointA055 {
    int x;
    int y;

    PointA055(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
