package com.acmicpc.season1.company24;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int testCase = 0;
    public static int[] vertexColor;
    public static boolean[] isVisited;
    public static ArrayList<ArrayList<Integer>> arrayList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
//            각 테스트 케이스의 첫째 줄에는 그래프의 정점의 개수 V와 간선의 개수 E가 빈 칸을
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            initialize(V);
            input(br, E);
            boolean isTestCase = bfs(V);
            if (isTestCase) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }

        }


        bw.flush();
        bw.close();
        br.close();

    }

    public static void initialize(int v) {
        arrayList = new ArrayList<>();

        for (int i = 0; i <= v; i++) {
            arrayList.add(new ArrayList<>());
        }
        v++;
        vertexColor = new int[v];
        isVisited = new boolean[v];
    }

    public static void input(BufferedReader br, int e) throws IOException {
        for (int j = 0; j < e; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());
            arrayList.get(vertex1).add(vertex2);
            arrayList.get(vertex2).add(vertex1);
        }

    }

    public static boolean bfs(int V) {

        Queue<Integer> queue = new LinkedList<>();

        for (int z = 1; z < V; z++) {
            if (isVisited[z]) {
                continue;
            }

            queue.add(z);
            isVisited[z] = true;
            vertexColor[z] = 1;

            while (!queue.isEmpty()) {
                int vertex = queue.poll();
                ArrayList<Integer> nextArrays = arrayList.get(vertex);

                for (int i = 0; i < nextArrays.size(); i++) {
                    int next = nextArrays.get(i);
                    if (vertexColor[next] == vertexColor[vertex]) {
                        return false;
                    }
                    if (isVisited[next]) {
                        continue;
                    }
                    queue.add(next);
                    isVisited[next] = true;
                    if (vertexColor[vertex] == 1) {
                        vertexColor[next] = 2;
                    } else {
                        vertexColor[next] = 1;
                    }
                }
            }
        }
        return true;
    }

}
