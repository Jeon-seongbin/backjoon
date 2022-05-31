package com.acmicpc.company27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N, R, Q;
    public static ArrayList<Integer>[] adjList;
    public static ArrayList<Integer>[] subList;

    public static int[] parent;
    public static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());


        parent = new int[N + 1];
        size = new int[N + 1];

        adjList = new ArrayList[N + 1];
        subList = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++) {
            adjList[i] = new ArrayList<>();
            subList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }

        makeTree(R, -1);
        countSub(R);
        for(int i = 0; i < Q; i++) {
            int q = Integer.parseInt(br.readLine());

            System.out.println(size[q]);
        }

        br.close();
    }

    public static void makeTree(int current, int par) {
        for (int next : adjList[current]) { //  adjList[current] -> array list 자체 를 돌린다
            if (par != next) {
                subList[current].add(next);
                parent[next] = current;
                makeTree(next, current);
            }
        }
    }

    public static void countSub(int cur) {
        size[cur] = 1;
        for(int next :subList[cur]){
            countSub(next);
            size[cur] += size[next];
        }
    }
}
