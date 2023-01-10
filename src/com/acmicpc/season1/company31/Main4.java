package com.acmicpc.season1.company31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main4 {
    public static int N;
    public static ArrayList<Node1967>[] arrayLists;

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


        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arrayLists[a].add(new Node1967(b, c));
            arrayLists[b].add(new Node1967(a, c));
        }

        max = Integer.MIN_VALUE;
        isVisited = new boolean[N + 1];
        bfs(1,0);
        max = Integer.MIN_VALUE;
        isVisited = new boolean[N + 1];

        bfs(end, 0);

        System.out.println(max);
    }

    public static void bfs(int cur, int dist) {
        if(max < dist){
            max = dist;
            end = cur;
        }

        isVisited[cur] = true;

        for( Node1967 next : arrayLists[cur]){
            if(isVisited[next.node]){
                continue;
            }

            bfs(next.node, dist+ next.dist );

        }

    }
}

class Node1967 {
    int node;
    int dist;

    Node1967(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}
