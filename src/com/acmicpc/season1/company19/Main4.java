package com.acmicpc.season1.company19;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/13549
public class Main4 {
    public static int N = 0;
    public static int M = 0;
    public static int result = 0;
    public static int[] map = new int[100001];
    public static boolean[] map1 = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        bfs();
        bw.write("" + map[M]);
        bw.flush();
        br.close();
        bw.close();
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(N);
        while (!queue.isEmpty()) {
            int n = queue.poll();
            if (n == M) {
                break;
            }
            if (n * 2 <= 100000 && map[n * 2] == 0 && !map1[n * 2]) {
                queue.offer(n * 2);
                map[n * 2] = map[n];
                map1[n * 2] = true;
            }
            if (0 <= n - 1 && map[n - 1] == 0 && !map1[n - 1]) {
                queue.offer(n - 1);
                map[n - 1] = map[n] + 1;
                map1[n - 1] = true;
            }
            if (n + 1 <= 100000 && map[n + 1] == 0 && !map1[n + 1]) {
                queue.offer(n + 1);
                map[n + 1] = map[n] + 1;
                map1[n + 1] = true;
            }

        }
    }
}
