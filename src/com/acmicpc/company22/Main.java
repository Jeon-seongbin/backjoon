package com.acmicpc.company22;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static int N, M;
    public static int[][] map;
    public static int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫째 줄에 도시의 개수 n이 주어지고
        N = Integer.parseInt(br.readLine());

        // 둘째 줄에는 버스의 개수 m이 주어진다.
        M = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = INF;
                if (i == j) {
                    map[i][j] = 0;
                }
            }
        }

        // 버스의 정보는 버스의 시작 도시 a, 도착 도시 b, 한 번 타는데 필요한 비용 c로 이루어져 있다.
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a][b] = Math.min(map[a][b], c);
        }

        floyd();
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (map[i][j] == INF) {
                    map[i][j] = 0;
                }
            }
        }


        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                System.out.print(map[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

    }

    public static void floyd() {
        for (int k = 1; k <= N; k++) { // 중간지점
            for (int i = 1; i <= N; i++) { // 시작지점
                for (int j = 1; j <= N; j++) { // 끝나는 지점
                    if (map[i][k] + map[k][j] < map[i][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
    }
}
