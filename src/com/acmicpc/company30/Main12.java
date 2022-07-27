package com.acmicpc.company30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//양 구출
public class Main12 {
    public static int N;
    public static ArrayList<Integer>[] map;
    public static ArrayList<Integer>[] tree;
    public static char[] animalTypes;
    public static int[] animalCounts;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        animalCounts = new int[N + 1];
        animalTypes = new char[N + 1];
        map = new ArrayList[N + 1];
        tree = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
            map[i] = new ArrayList<>();
        }

        for (int i = 2; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // S 100 3
            animalTypes[i] = st.nextToken().charAt(0);
            animalCounts[i] = Integer.parseInt(st.nextToken());
            int parents = Integer.parseInt(st.nextToken());
            map[parents].add(i);
            map[i].add(parents);
        }
        makeTree();
        System.out.println(count(1));
    }

    public static void makeTree() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        boolean[] isVisited = new boolean[N + 1];
        isVisited[1] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : map[now]) {
                if (isVisited[next]) {
                    continue;
                }
                tree[now].add(next);
                isVisited[next] = true;
                queue.add(next);
            }
        }
    }

    public static long count(int now) {
        long sum = 0;
        for (int next : tree[now]) {
            sum += count(next);
        }
        if (animalTypes[now] == 'S') {
            return sum += animalCounts[now];
        } else {
            return Math.max(0, sum - animalCounts[now]);
        }
    }
}
