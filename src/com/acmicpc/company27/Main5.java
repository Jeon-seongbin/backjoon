package com.acmicpc.company27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main5 {
    public static int N, M;
    public static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[M];
        dfs(1,0);
        br.close();
    }

    public static void dfs(int at, int depth) {
        if (depth == M) {
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = at; i <= N; i++) {
            result[depth] = i;
            dfs(i + 1, depth + 1);
        }

    }
}
