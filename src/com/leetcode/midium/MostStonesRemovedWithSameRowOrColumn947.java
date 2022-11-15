package com.leetcode.midium;

import java.util.ArrayList;
import java.util.List;

public class MostStonesRemovedWithSameRowOrColumn947 {
    public static void main(String[] args) {

        /*
            https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/solutions/2812465/it-s-literally-a-graph-dfs-and-union-find/
         */
    }

    public static int removeStones(int[][] stones) {
        int stoneLength = stones.length;
        if (stoneLength <= 1) {
            return 0;
        }

        List<Integer>[] graph = new List[stoneLength];
        for (int i = 0; i < stoneLength; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < stoneLength; i++) {
            int[] u = stones[i];
            for (int j = 0; j < stoneLength; j++) {
                if (i == j) {
                    continue;
                }
                int[] v = stones[j];

                if (u[0] == v[0] || v[1] == u[1]) {
                    graph[i].add(j);
                }
            }
        }
        boolean[] visited = new boolean[stoneLength];
        int ans = 0;


        for (int i = 0; i < stoneLength; i++) {
            if (visited[i]) {
                continue;
            }
            dfs(graph, visited, i);
            ans++;
        }

        return stoneLength - ans;
    }

    public static void dfs(List<Integer>[] graph, boolean[] visited, int start) {
        visited[start] = true;
        List<Integer> next = graph[start];
        for (int nextNumber : next) {
            if (visited[nextNumber]) {
                continue;
            }

            dfs(graph, visited, nextNumber);
        }
    }
}
