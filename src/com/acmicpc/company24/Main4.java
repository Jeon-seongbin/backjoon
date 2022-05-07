package com.acmicpc.company24;

import java.io.*;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1956
public class Main4 {

    public static int V, E;
    public static int map[][];
    public static int INF = 4000000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // V개의 마을와 E개의 도로로
        // 첫째 줄에 V와 E가 빈칸을 사이에 두고 주어진다.
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        map = new int[V + 1][V + 1];
        for (int i = 1; i < V+ 1; i++) {
            for (int j = 1; j < V+ 1; j++) {
                map[i][j] = INF;
            }
        }
        //  E개의 줄에는 각각 세 개의 정수 a, b, c가 주어진다. a번 마을에서 b번 마을로 가는 거리가 c인 도로
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a][b] = c;
        }

        //  도로의 길이의 합이 최소가 되도록 찾으려고 한다.
        for (int k = 1; k < V + 1; k++) {
            for (int i = 1; i < V + 1; i++) {
                for (int j = 1; j < V + 1; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        int result = INF;
        for (int i = 1; i < V + 1; i++) {
            for (int j = 1; j < V + 1; j++) {
                if (i == j) continue;
                result = Math.min(result, map[i][j] + map[j][i]);
            }
        }

        if (result == INF) {
            result = -1;
        }
        bw.write("" + result);
        bw.flush();


    }
}
