package com.acmicpc.season1.package15;


import java.io.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main6 {

    int[][] map;

    // 가로
    int N;

    //세로
    int M;

    boolean[][] visit;
    int count = 0;

    public void putMap(int n, int m) {
        map[n][m] = 1;
    }

    public int bfs() {
        int count = 0;
        Queue<Pair1> queue = new LinkedList<>();

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 || visit[i][j]) {
                    continue;
                }

                queue.add(new Pair1(i, j));
                count++;
                visit[i][j] = true;

                while (!queue.isEmpty()) {

                    Pair1 pair1 = queue.poll();

                    for (int z = 0; z < 4; z++) {
                        int newN = pair1.m + dx[z];
                        int newM = pair1.n + dy[z];

                        if (newN < 0 || newM < 0 || N <= newN || M <= newM) {
                            continue;
                        }

                        if (map[newN][newM] == 1 && visit[newN][newM] == false) {
                            // 기존에 있는 큐에서 큐를 더한다
                            queue.offer(new Pair1(newN, newM));

                            // 새로운 좌표에 true입력
                            visit[newN][newM] = true;
                        }

                    }
                }

            }
        }
        return count;
    }

    Main6(int x, int y) {
        this.N = y + 1;
        this.M = x + 1;
        visit = new boolean[this.N][this.M];
        map = new int[this.N][this.M];
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] testCases = new int[Integer.parseInt(st.nextToken())];

        for (int testCase : testCases) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            Main6 m = new Main6(M, N);
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                m.putMap(y, x);
            }
            int result = m.bfs();
            bw.write("" + result + "\n");

        }

        bw.flush();
        bw.close();
        br.close();
    }
}

class Pair1 {
    int n;
    int m;

    Pair1(int x, int y) {
        this.m = x;
        this.n = y;
    }
}
