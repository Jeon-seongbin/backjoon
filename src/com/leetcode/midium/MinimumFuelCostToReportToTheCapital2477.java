package com.leetcode.midium;

import java.util.ArrayList;


public class MinimumFuelCostToReportToTheCapital2477 {
    public static void main(String[] args) {

    }


    public static long answer = 0;

    public long minimumFuelCost(int[][] roads, int seats) {
        ArrayList<Integer>[] graph = new ArrayList[roads.length + 1];
        for (int i = 0; i < roads.length + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            final int from = road[0];
            final int to = road[1];
            graph[from].add(to);
            graph[to].add(from);
        }

        dfs(graph, 0, -1, seats);
        return answer;

    }

    public static int dfs(ArrayList<Integer>[] graph, int now, int prev, int seats) {

        int people = 1;

        for (final int next : graph[now]) {
            if (next == prev) {
                continue;
            }
            people += dfs(graph, next, now, seats);
        }

        if (now > 0) {
            answer += (people + seats - 1) / seats;
            System.out.println("--");
            System.out.println("now:" + now);
            System.out.println(answer);
            System.out.println("--");

        }
        return people;
    }
}