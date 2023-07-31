package com.programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Edge implements Comparable<Edge> {
    int index;
    int cost;

    Edge(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge e) {
        return this.cost - e.cost;
    }
}

public class TaxiGetTogether {
    public static void main(String[] args) {

    }

    static final int MAX = 20000001;

    static ArrayList<ArrayList<Edge>> graph;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;

        graph = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            graph = new ArrayList<>();
        }

        for (int i = 0; i < fares.length; i++) {
            graph.get(fares[i][0]).add(new Edge(fares[i][1], fares[i][2]));
            graph.get(fares[i][1]).add(new Edge(fares[i][0], fares[i][2]));
        }

        int[] whenstartACost = new int[n + 1];
        int[] whenstartBCost = new int[n + 1];
        int[] whenstartCost = new int[n + 1];

        Arrays.fill(whenstartACost, MAX);
        Arrays.fill(whenstartBCost, MAX);
        Arrays.fill(whenstartCost, MAX);

        whenstartACost = dijkstra(a, whenstartACost);
        whenstartBCost = dijkstra(a, whenstartBCost);
        whenstartCost = dijkstra(a, whenstartCost);


        for (int i = 0; i < n + 1; i++) {
            answer = Math.min(answer, whenstartACost[i] + whenstartBCost[i] + whenstartCost[i]);
        }
        return answer;
    }

    static int[] dijkstra(int start, int[] costs) {

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        costs[start] = 0;

        while (!pq.isEmpty()) {
            Edge nowPoint = pq.poll();
            int nowIndex = nowPoint.index;
            int nowCost = nowPoint.cost;

            if (costs[nowIndex] < nowCost) {
                continue;
            }

            ArrayList<Edge> nextEdges = graph.get(nowIndex);

            for (Edge edge : nextEdges) {

                int nextCost = costs[nowIndex] + edge.cost;
                if (nextCost < costs[edge.index]) {
                    costs[edge.index] = nextCost;
                    pq.offer(new Edge(edge.index, nextCost));
                }
            }

        }
        return costs;
    }

    public int solution1(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;

        int[][] dp = new int[n + 1][n + 1];
        int max = 20000001;

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == j) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = max;
            }
        }

        for (int i = 0; i < fares.length; i++) {
            int start = fares[i][0];
            int end = fares[i][1];
            int cost = fares[i][2];
            dp[start][end] = cost;
            dp[end][start] = cost;
        }

        for (int z = 0; z < n + 1; z++) {
            for (int i = 0; i < n + 1; i++) {
                for (int j = 0; j < n + 1; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][z] + dp[z][j]);
                }
            }
        }


        answer = dp[s][a] + dp[s][b];

        for (int i = 0; i < n + 1; i++) {
            answer = Math.min(answer, dp[s][i] + dp[i][a] + dp[i][b]);
        }

        return answer;
    }
}
