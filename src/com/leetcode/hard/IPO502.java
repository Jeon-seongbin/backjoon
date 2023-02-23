package com.leetcode.hard;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class IPO502 {
    public static void main(String[] args) {
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Pair[] projects = new Pair[n];
        for (int i = 0; i < n; i++) {
            projects[i] = new Pair(capital[i], profits[i]);
        }
        Arrays.sort(projects);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        int j = 0;
        int ans = w;
        for (int i = 0; i < k; i++) {
            while (j < n && projects[j].capital <= ans) {
                priorityQueue.add(projects[j++].profit);
            }
            if (priorityQueue.isEmpty()) {
                break;
            }
            ans += priorityQueue.poll();
        }
        return ans;
    }

    class Pair implements Comparable<Pair> {
        int capital;
        int profit;

        public Pair(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }

        @Override
        public int compareTo(Pair o) {
            return capital - o.capital;
        }
    }
}
