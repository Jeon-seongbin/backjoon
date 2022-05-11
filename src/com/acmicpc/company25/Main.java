package com.acmicpc.company25;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // 능력이 부족해서 총 K번만 위와 같이 움직일 수 있고,
    public static int K ;

    // 가로길이 W, 세로길이 H가 주어진다
    public static int W , H ;

    public static int[][] map;
    public static boolean[][][] isVisited;

    // 그 외에는 그냥 인접한 칸으로만 움직일 수 있다.
//    public static int[] dx = {1, 0, -1, 0, -2, -2, -1, -1, 1, 1, 2, 2};
//    public static int[] dy = {0, -1, 0, 1, 1, -1, 2, -2, 2, -2, 1, -1};
    static int[] dx = {1, 0, -1, 0, -1, -2, -2, -1, 1, 2, 1, 2};
    static int[] dy = {0, 1, 0, -1, -2, -1, 1, 2, -2, -1, 2, 1};


    public static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫째 줄에 정수 K가 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());

        // 둘째 줄에 격자판의 가로길이 W, 세로길이 H가 주어진다
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        isVisited = new boolean[H][W][K + 1];

        // 0은 아무것도 없는 평지, 1은 장애물을 뜻한다.
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        result = -1;
        bfs();


        bw.write("" + result);
        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs() {
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(0, 0, 0, 0));

        isVisited[0][0][0] = true;
        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            // 도착지에 도달
            if (currentPoint.x == H - 1 && currentPoint.y == W - 1) {
                result = currentPoint.dist;
                break;
            }

            int loof = currentPoint.kCount >= K ? 4 : 12;


            for (int i = 0; i < loof; i++) {
                int newX = currentPoint.x + dx[i];
                int newY = currentPoint.y + dy[i];

                if (newX < 0 || H <= newX || newY < 0 || W <= newY) {
                    continue;
                }
                if (map[newX][newY] == 1) continue;

                if (i < 4) {
                    // 이미 왔던 곳이라면
                    if (isVisited[newX][newY][currentPoint.kCount]) continue;
                    isVisited[newX][newY][currentPoint.kCount] = true;
                    queue.add(new Point(newX, newY, currentPoint.dist + 1, currentPoint.kCount));
                }
                // 말처럼 이동할 경우
                else {
                    if (isVisited[newX][newY][currentPoint.kCount + 1]) continue;
                    isVisited[newX][newY][currentPoint.kCount + 1] = true;
                    queue.add(new Point(newX, newY, currentPoint.dist + 1, currentPoint.kCount + 1));
                }
            }
        }
    }
}

class Point {
    int x;
    int y;
    int dist;
    int kCount;


    Point(int x, int y, int dist, int kCount) {
        this.x = x;
        this.y = y;
        this.dist = dist;
        this.kCount = kCount;
    }
}
