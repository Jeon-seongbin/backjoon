package com.acmicpc.company25;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main6 {

    public static int R, C;
    public static char[][] map;
    public static boolean[][] isVisited;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static Point3197[] duckPoints;
    public static Queue<Point3197> duckQ;
    public static Queue<Point3197> waterQ;

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력의 첫째 줄에는 R과 C가 주어진다. 단, 1 ≤ R, C ≤ 1500.
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        isVisited = new boolean[R][C];
        duckPoints = new Point3197[2];
        waterQ = new LinkedList<>();
        duckQ = new LinkedList<>();

        int count = 0;
        for (int i = 0; i < R; i++) {
            String a = br.readLine();
            for (int j = 0; j < C; j++) {
                char b = a.charAt(j);
                map[i][j] = b;
                if (b == 'L') {
                    duckPoints[count] = new Point3197(i, j);
                    count++;
                }
                if (b != 'X') {
                    waterQ.add(new Point3197(i, j));
                }
            }
        }

        duckQ.offer(duckPoints[0]);
        count = 0;
        isVisited[duckPoints[0].x][duckPoints[0].y] = true;

        boolean meet = false;
        while (true) {
            Queue<Point3197> nextQ = new LinkedList<>();

            while (!duckQ.isEmpty()) {
                Point3197 now = duckQ.poll();
                if (now.x == duckPoints[1].x && now.y == duckPoints[1].y) {
                    meet = true;
                    break;
                }
                for (int i = 0; i < 4; i++) {
                    int nextX = now.x + dx[i];
                    int nextY = now.y + dy[i];

                    if (nextX < 0 || R <= nextX || nextY < 0 || C <= nextY) {
                        continue;
                    }

                    if (isVisited[nextX][nextY]) {
                        continue;
                    }
                    isVisited[nextX][nextY] = true;
                    if (map[nextX][nextY] == 'X') {
                        nextQ.add(new Point3197(nextX, nextY));
                        continue;
                    }
                    duckQ.add(new Point3197(nextX, nextY));

                }
            }
            if (meet) {
                break;
            }

            duckQ = nextQ;


            int waterSize = waterQ.size();
            for (int zz = 0; zz < waterSize; zz++) {
                Point3197 waterPoint = waterQ.poll();

                for (int i = 0; i < 4; i++) {
                    int nextX = waterPoint.x + dx[i];
                    int nextY = waterPoint.y + dy[i];

                    if (nextX < 0 || R <= nextX || nextY < 0 || C <= nextY) {
                        continue;
                    }

                    if (map[nextX][nextY] == 'X') {
                        map[nextX][nextY] = '.';
                        waterQ.add(new Point3197(nextX, nextY));
                    }

                }

            }
            count++;
        }

        System.out.println(count);
    }
}

class Point3197 {
    int x;
    int y;

    Point3197(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
