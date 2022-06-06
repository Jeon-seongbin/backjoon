package com.acmicpc.company27;

import java.io.*;
import java.util.StringTokenizer;

public class Main3 {
    public static int N, M;
    public static int[] result;
    public static boolean[] isUsed;

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[N + 1];
        isUsed = new boolean[N + 1];
        backTracking(0);
    }

    public static void backTracking(int index) {
        if (index == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < N; i++) {
            if (isUsed[i]) {
                continue;
            }
            isUsed[i] = true;
            result[index] = i + 1;
            backTracking(index + 1);
            isUsed[i] = false;
        }
    }
}
