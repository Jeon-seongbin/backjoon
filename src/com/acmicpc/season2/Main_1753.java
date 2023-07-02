package com.acmicpc.season2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753 {

    public static int V;
    public static int E;

    public static int startingPoint;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 첫째 줄에 정점의 개수 V와 간선의 개수 E가 주어진다.
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());


        ArrayList<ArrayList<Node>> nodes = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            nodes.add(new ArrayList<>());
        }

        // 둘째 줄에는 시작 정점의 번호 K(1 ≤ K ≤ V)가 주어진다
        st = new StringTokenizer(br.readLine());
        startingPoint = Integer.parseInt(st.nextToken());

        // 셋째 줄부터 E개의 줄에 걸쳐 각 간선을 나타내는 세 개의 정수 (u, v, w)가 순서대로 주어진다. 이는 u에서 v로 가는 가중치 w인 간선이 존재한다는 뜻이다.
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            nodes.get(u).add(new Node(v, w));
        }


        int[] costs = new int[100001];
        Arrays.fill(costs, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(startingPoint, 0));
        costs[startingPoint] = 0;

        while (!pq.isEmpty()) {
            Node nowNode = pq.poll();

            int now = nowNode.nowPoint;
            int nowCost = nowNode.cost;

            if (costs[now] < nowCost) {
                continue;
            }

            for (int i = 0; i < nodes.get(now).size(); i++) {
                int nextCost = nodes.get(now).get(i).cost;
                int nextPoint = nodes.get(now).get(i).nowPoint;

                int allCost = nowCost + nextCost;
                if (allCost < costs[nextPoint]) {
                    costs[nextPoint] = allCost;
                    pq.add(new Node(nextPoint, allCost));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            sb.append(costs[i] == Integer.MAX_VALUE ? "INF" : costs[i]).append("\n");
        }
        System.out.println(sb.toString());
    }


    public static class Node implements Comparable<Node> {
        int nowPoint;
        int cost;

        Node(int nowPoint, int cost) {
            this.nowPoint = nowPoint;
            this.cost = cost;
        }

        // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
        @Override
        public int compareTo(Node other) {
            if (this.cost < other.cost) {
                return -1;
            }
            return 1;
        }
    }
}
