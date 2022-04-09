package com.acmicpc.package17;

import java.io.*;
import java.util.*;

public class Main3 {
    public static int N, M;
    public static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    public static boolean[] isVisited;
    public static int[] depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N + 1; i++) {
            arrayList.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arrayList.get(a).add(b);

        }

//        depth = new int[N + 1];
        isVisited = new boolean[N + 1];

        depth = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {

            isVisited = new boolean[N + 1];

            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            isVisited[i] = true;
            while (!queue.isEmpty()) {
                int nowCom = queue.poll();

                for (int j = 0; j < arrayList.get(nowCom).size(); j++) {
                    int nextCom = arrayList.get(nowCom).get(j);
                    if (isVisited[nextCom]) {
                        continue;
                    }

                    isVisited[nextCom] = true;
                    depth[nextCom]++;
                    queue.add(nextCom);

                }
            }
        }

        int max = Integer.MIN_VALUE;


        for (int i = 1; i < N + 1; i++) {
            max = Math.max(depth[i], max);
        }

        for (int i = 1; i < N + 1; i++) {
            if (max == depth[i]) {
                bw.write(i + " ");
            }
        }
        bw.flush();
        bw.close();

    }
}
