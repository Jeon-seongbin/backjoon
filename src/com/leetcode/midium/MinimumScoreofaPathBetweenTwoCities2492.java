package com.leetcode.midium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumScoreofaPathBetweenTwoCities2492 {
    public static void main(String[] args) {

    }

    class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public int minScore(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
        }


        for (int i = 0; i < roads.length; i++) {
            adj.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }

        boolean[] visit = new boolean[n + 1];
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(1, Integer.MAX_VALUE));
        int ans = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Pair now = queue.poll();
            ans = Math.min(ans, now.dist);
            visit[now.node] = true;
            for (Pair next : adj.get(now.node)) {
                if (visit[next.node]) {
                    continue;
                }

                queue.add(next);
            }
        }
        return ans;
    }
}
