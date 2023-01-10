package com.acmicpc.season1.package22;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정점의 개수 N과
        int N = Integer.parseInt(st.nextToken());

        //간선의 개수 M이 주어진다
        int M = Integer.parseInt(st.nextToken());
        boolean[] isVisited = new boolean[N + 1];
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            arrayList.add(new ArrayList<>());
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            // 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v)
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arrayList.get(u).add(v);
            arrayList.get(v).add(u);

        }


        int count = 0;
        for (int i = 1; i < N + 1; i++) {
            if (isVisited[i]) {
                continue;
            }

            Queue<Integer> nodeQueue = new LinkedList<>();

            nodeQueue.add(i);
            isVisited[i] = true;
            count++;

            while (!nodeQueue.isEmpty()) {
                int node = nodeQueue.poll();
                ArrayList<Integer> renketuSareteiruNode = arrayList.get(node);
                for (int z = 0; z < renketuSareteiruNode.size(); z++) {
                    int nodeZ = renketuSareteiruNode.get(z);

                    if (isVisited[nodeZ]) {
                        continue;
                    }

                    nodeQueue.add(nodeZ);
                    isVisited[nodeZ] = true;
                }

            }

        }

        bw.write("" + count);
        bw.flush();
        bw.close();
        br.close();

    }
}
