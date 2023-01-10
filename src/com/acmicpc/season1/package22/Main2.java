package com.acmicpc.season1.package22;


import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1260
public class Main2 {

    public static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    public static int N, M, V;
    public static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다.
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        // 1번은 쓰지 않는다
        for (int i = 0; i < N + 1; i++) {
            arrayList.add(new ArrayList<>());
        }


        // 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다.
        for (int i = 0; i < M; i++) {
            // 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.
            st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());

            // 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고,
            arrayList.get(one).add(two);
            arrayList.get(two).add(one);
        }

        for (int i = 0; i < N + 1; i++) {
            ArrayList<Integer> temp = arrayList.get(i);
            Collections.sort(temp);
            arrayList.set(i, temp);
        }

        isVisited = new boolean[N + 1];
        dfs(V);

        System.out.println();
        isVisited = new boolean[N + 1];
        bfs();
    }

    public static void bfs() {

        Queue<Integer> nodeQueue = new LinkedList<>();

        nodeQueue.add(V);
        isVisited[V] = true;
        while (!nodeQueue.isEmpty()) {
            int v = nodeQueue.poll();

            System.out.print(v + " ");
            for (int i = 0; i < arrayList.get(v).size(); i++) {

                int newNode = arrayList.get(v).get(i);
                if (isVisited[newNode]) {
                    continue;
                }
                isVisited[newNode] = true;
                nodeQueue.offer(newNode);
            }

        }
    }


    public static void dfs(int v) {
        isVisited[v] = true;
        System.out.print(v + " ");
        for (int i = 0; i < arrayList.get(v).size(); i++) {
            int newNode = arrayList.get(v).get(i);
            if (isVisited[newNode]) {
                continue;
            }

            isVisited[newNode] = true;
            dfs(newNode);

        }

    }
}
