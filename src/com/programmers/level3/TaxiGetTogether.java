package com.programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class TaxiGetTogether {
    static class Node implements Comparable<Node> {
        int cost;
        int nodeNumber;

        Node(int nodeNumber,  int cost ) {
            this.nodeNumber = nodeNumber;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

    public static ArrayList<ArrayList<Node>> graph;
    public static int MAX = Integer.MAX_VALUE;

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < fares.length; i++) {
            graph.get(fares[i][0]).add(new Node(fares[i][1], fares[i][2]));
            graph.get(fares[i][1]).add(new Node(fares[i][0], fares[i][2]));
        }
        int[] whenstartACost = new int[n + 1];
        int[] whenstartBCost = new int[n + 1];
        int[] whenstartCost = new int[n + 1];
        Arrays.fill(whenstartACost, MAX);
        Arrays.fill(whenstartBCost, MAX);
        Arrays.fill(whenstartCost, MAX);

        whenstartACost = dijkstra(a, whenstartACost);
        whenstartBCost = dijkstra(b, whenstartBCost);
        whenstartCost = dijkstra(s, whenstartCost);

        for (int i = 0; i <= n; i++) {
            answer = Math.min(answer, whenstartACost[i] + whenstartBCost[i] + whenstartCost[i]);
        }

        return answer;
    }

    public static int[] dijkstra(int startPoint, int[] costs) {

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(startPoint, 0));
        costs[startPoint] = 0;

        while (!q.isEmpty()) {
            Node nowNode = q.poll();
            int nowIndex = nowNode.nodeNumber;
            int nowCost = nowNode.cost;

            if (costs[nowIndex] < nowCost) {
                continue;
            }

            ArrayList<Node> nextEdges = graph.get(nowIndex);

            for (Node edge : nextEdges) {

                int nextCost = costs[nowIndex] + edge.cost;
                if (  nextCost< costs[edge.nodeNumber]) {
                    costs[edge.nodeNumber] = nextCost;
                    q.offer(new Node(edge.nodeNumber, nextCost));
                }
            }
        }
        return costs;
    }

    public static void main(String[] args) {
        solution(6, 4, 6, 2, new int[][]
                {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}}
        );

    }
}
