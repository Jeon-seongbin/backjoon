package com.acmicpc.company31;

import java.io.*;
import java.util.ArrayList;

public class Main2 {
    public static int N;
    public static int[] person;
    public static int[][] dp;
    public static ArrayList<Integer>[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        person = new int[N + 1];
        v = new ArrayList[N + 1];
        dp = new int[N + 1][2];

        for (int i = 0; i <= N; i++) {
            v[i] = new ArrayList<>();
        }

        String[] input = br.readLine().split(" ");

        for (int i = 1; i <= N; i++) {
            person[i] = Integer.parseInt(input[i - 1]);
        }

        for (int i = 0; i < N - 1; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            v[a].add(b);
            v[b].add(a);
        }
        dfs(1, 0);
        bw.write(Math.max(dp[1][0], dp[1][1]) + "\n");
        bw.flush();

    }

    public static void dfs(int now, int parent) {
        for (int next : v[now]) {
            if (next != parent) {
                dfs(next, now);
                dp[now][0] += Math.max(dp[next][0], dp[next][1]);
                dp[now][1] += dp[next][0];
            }
        }
        dp[now][1] += person[now];
    }
}

// https://lotuslee.tistory.com/96