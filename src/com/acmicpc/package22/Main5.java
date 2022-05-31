package com.acmicpc.package22;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main5 {
    public static int n, m;
    public static int[] parents;
    public static int[] size;
    public static int[] result;
    public static boolean[] isVisited;
    public static ArrayList<Integer>[] arrayLists;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //  회사의 직원 수 n명, 최초의 칭찬의 횟수 m이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parents = new int[n + 1];
        size = new int[n + 1];
        result = new int[n + 1];
        arrayLists = new ArrayList[n + 1];
        isVisited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            arrayLists[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (a == -1) {
                continue;
            }
            arrayLists[a].add(i);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            result[a] += b;
        }
        dfs(1);
        for (int i = 1; i < n + 1; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static void dfs(int parent) {
        for (int next : arrayLists[parent]) {
            result[next] += result[parent];
            dfs(next);
        }
    }
}
