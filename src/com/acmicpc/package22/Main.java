package com.acmicpc.package22;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다.
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        boolean[] isVisisted = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {

            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            String[] nv = br.readLine().split(" ");
            int n1 = Integer.parseInt(nv[0]);
            int n2 = Integer.parseInt(nv[1]);

            graph.get(n1).add(n2);
            graph.get(n2).add(n1);

        }

        int count = 0;

        for (int i = 0; i < N; i++) {
//            ArrayList<Integer> arr = graph.get(i);
//            if(arr.isEmpty()){
//                continue;
//            }

            if(isVisisted[i]== true){
                continue;
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            isVisisted[i] = true;
            count++;

            while (!queue.isEmpty()) {
                Integer a = queue.poll();

                for (int j = 0; j < graph.get(a).size(); j++) {
                    int node =graph.get(a).get(j);
                    if (isVisisted[node] == false) {
                        isVisisted[node] = true;
                        queue.add(node);
                    }

                }
            }
        }

        bw.write("" + (count - 1));
        bw.flush();
        bw.close();
        br.close();
    }
}
