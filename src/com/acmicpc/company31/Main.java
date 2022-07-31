package com.acmicpc.company31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 텀 프로젝트
public class Main {
    public static int testCase;
    public static int[] arr;
    public static boolean[] visited;
    public static boolean[] finished;

    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCase; tc++) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N + 1];
            visited = new boolean[N + 1];
            finished = new boolean[N + 1];
            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 1; i < N + 1; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i < N + 1; i++) {
                if (!finished[i]) {
                    dfs(i);
                }
            }
            System.out.println(N - count);
        }
    }

    public static void dfs(int now) {
        if (visited[now]) {
            finished[now] = true;
            count++;
        } else {
            visited[now] = true;
        }
        int next = arr[now];

        if (!finished[next]) {
            dfs(next);
        }
        visited[now] = false;
        finished[now] = true;
    }
}

// https://bcp0109.tistory.com/32