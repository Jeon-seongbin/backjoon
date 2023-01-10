package com.acmicpc.season1.company13;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        // 데이터 저장
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt("" + str.charAt(j));
            }
        }

        // 실행
        int result = bfs(map, N, M);

        bw.write("" + result);
        bw.flush();
        bw.close();
        br.close();
    }

    public static int bfs(int[][] map, int N, int M) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0));

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        //  오른쪽 아래 왼쪽 위를 표현한 것 뿐
        int[][] visit = new int[N][M];

        visit[0][0] = 1;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            for (int index = 0; index < 4; index++) {
                int newX = dx[index] + pair.getX();
                int newY = dy[index] + pair.getY();

                if (newX < 0 || newY < 0 || N <= newX || M <= newY) {
                    continue;
                }

                if (map[newX][newY] == 1 && visit[newX][newY] == 0) {
                    queue.offer(new Pair(newX, newY));

                    visit[newX][newY] = visit[pair.getX()][pair.getY()] + 1;
                }
            }
        }
        return visit[N - 1][M - 1];
    }
}

class Pair {
    private int x;
    private int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}

