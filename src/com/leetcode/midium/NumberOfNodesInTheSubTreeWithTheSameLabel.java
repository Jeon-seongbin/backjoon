package com.leetcode.midium;

import java.util.ArrayList;

public class NumberOfNodesInTheSubTreeWithTheSameLabel {
    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {
                {0, 1},
                {0, 2},
                {1, 4},
                {1, 5},
                {2, 3},
                {2, 6}
        };
        String labels = "abaedcd";
        countSubTrees(n, edges, labels);

    }

    public static ArrayList<ArrayList<Integer>> arrayList;
    public static boolean[] isVisited;
    public static int[] result;

    public static int[] countSubTrees(int n, int[][] edges, String labels) {
        isVisited = new boolean[n];
        result = new int[n];
        arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];

            arrayList.get(start).add(end);
            arrayList.get(end).add(start);
        }

        dfs(0, labels);
        return result;
    }

    public static int[] dfs(int node, String labels) {
        isVisited[node] = true;
        int[] count = new int[26];

        for (int i = 0; i < arrayList.get(node).size(); i++) {
            int next = arrayList.get(node).get(i);
            if (isVisited[next]) {
                continue;
            }
            int[] adjustCount = dfs(next, labels);
            for (int j = 0; j < 26; j++) {
                count[j] += adjustCount[j];
            }
        }

        char ch = labels.charAt(node);
        count[ch - 'a']++;
        result[node] = count[ch - 'a'];
        return count;
    }

}
