package com.acmicpc.company30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main12 {
    public static char[] types;
    public static int[] animalsCount;
    public static ArrayList<Integer>[] tree;
    public static ArrayList<Integer>[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        types = new char[N + 1];
        animalsCount = new int[N + 1];
        tree = new ArrayList[N + 1];
        map = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
            tree[i] = new ArrayList<>();
        }


        for (int i = 2; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String type = st.nextToken();
            int animalCount = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            types[i] = type.charAt(0);
            animalsCount[i] = animalCount;
            map[i].add(p);
            map[p].add(i);

        }
        makeTree(N);
        System.out.println(count(1));
    }

    public static void makeTree(int N) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        boolean[] visited = new boolean[N + 1];
        visited[1] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (Integer next : map[now]) {
                if (visited[next]) continue;
                visited[next] = true;
                tree[now].add(next);
                queue.add(next);
            }
        }
    }

    public static long count(int idx) {
        long sum = 0;
        for (int next : tree[idx]) {
            sum += count(next);
        }
        if (types[idx] =='S')
            return sum += animalsCount[idx];
        else
            return Math.max(sum - animalsCount[idx], 0);

    }
}
