package com.acmicpc.season1.company31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main3 {
    public static int N;
    public static ArrayList<Integer>[] arrayLists;
    public static int[][] dp;

    public static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1][2];
        isVisited = new boolean[N + 1];
        arrayLists = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arrayLists[a].add(b);
            arrayLists[b].add(a);
        }
        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    public static void dfs(int now) {
        isVisited[now] = true;
        dp[now][1] = 1; // 해당 number가 얼리어답터가 아닌 경우
        dp[now][0] = 0; // 해당 number가 얼리어답터인 경우(우선 시작 시 해당 지점 얼리어답터이므로 개수 1)

        for (int next : arrayLists[now]) {
            if (isVisited[next]) {
                continue;
            }
            dfs(next);
            dp[now][0] += dp[next][1];
            dp[now][1] += Math.min(dp[next][0], dp[next][1]);

        }

    }
}
