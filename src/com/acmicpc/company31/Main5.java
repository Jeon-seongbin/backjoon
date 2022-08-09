package com.acmicpc.company31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main5 {
    public static int N;
    public static ArrayList<Node1167>[] arrayLists;
    public static boolean[] isVisited;

    public static int max;
    public static int end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arrayLists = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1) {
                    break;
                }
                int weight = Integer.parseInt(st.nextToken());
                arrayLists[from].add(new Node1167(to, weight));
            }
        }
        max = Integer.MIN_VALUE;
        isVisited = new boolean[N + 1];
        dfs(1, 0);

        max = Integer.MIN_VALUE;
        isVisited = new boolean[N + 1];

        dfs(end, 0);
        System.out.println(max);
    }

    public static void dfs(int cur, int weight) {
        isVisited[cur] = true;
        if (max < weight) {
            max = weight;
            end = cur;
        }

        for (Node1167 next : arrayLists[cur]) {
            if (isVisited[next.node]) {
                continue;
            }
            dfs(next.node, weight + next.weight);
        }

    }
}

class Node1167 {
    int node;
    int weight;

    Node1167(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}
