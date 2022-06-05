package com.acmicpc.company27;

import java.io.*;
import java.util.StringTokenizer;

public class Main3 {
    public static int N, M;
    public static int[] result;
    public static boolean[] isUsed;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
        result = new int[N + 1];
        isUsed = new boolean[N + 1];
        go(0);
    }

    public static void go(int index) {
        if (index == M) {
            for (int i = 0; i < M; i++) {
                System.out.print("" + result[i]+" ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (isUsed[i]) {
                continue;
            }
            isUsed[i] = true;
            result[index] = i;
            go(index + 1);
            isUsed[i] = false;
        }
    }
}
