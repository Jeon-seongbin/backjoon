package com.acmicpc.company22;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11725
public class Main3 {
    public static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    public static int[] parents;
    public static boolean[] isVisited;
    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count + 1; i++) {
            arrayList.add(new ArrayList<>());
        }

        parents = new int[count + 1];
        isVisited = new boolean[count + 1];

        for (int i = 0; i < count - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arrayList.get(a).add(b);
            arrayList.get(b).add(a);
        }

        bfs(1);

        for (int i = 2; i < count + 1; i++) {
            bw.write("" + parents[i] + "\n");
        }
        bw.flush();
    }

    public static void bfs(int start) {
        isVisited[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int q = queue.poll();
            for (int i = 0; i < arrayList.get(q).size(); i++) {
                int next = arrayList.get(q).get(i);
                if (isVisited[next]) {
                    continue;
                }
                parents[next] = q;
                isVisited[next] = true;
                queue.add(next);
            }
        }
    }


}
