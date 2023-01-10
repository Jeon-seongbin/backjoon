package com.acmicpc.season1.company20;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main4 {
    public static int[] map;
    public static int mapSize;
    public static int S;
    public static int G;
    public static int U;
    public static int D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        mapSize = Integer.parseInt(st.nextToken());
        map = new int[mapSize + 1];

        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        bfs();
        if (map[G] - 1 == -1) {
            bw.write("use the stairs");

        } else {
            bw.write("" + (map[G] - 1));
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        map[S] = 1;
        queue.add(S);
        while (!queue.isEmpty()) {
            int s = queue.poll();

            // 방문 한 곳 제외

            // 계산 한 것이 범위 벗어나는것 제외
            if (1 <= s - D && map[s - D] == 0) {
                map[s - D] = map[s] + 1;
                queue.add(s - D);
            }
            if (s + U <= mapSize && map[s + U] == 0) {
                map[s + U] = map[s] + 1;
                queue.add(s + U);
            }
        }
    }
}
