package com.leetcode.midium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightsWithinKStops787 {
    public static void main(String[] args) {

    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }


        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{src, 0});

        int[] minCount = new int[n];

        for (int i = 0; i < n; i++) {
            minCount[i] = Integer.MAX_VALUE;
        }

        int stops = 0;

        while (!q.isEmpty() && stops <= k) {

            for (int i = 0; i < q.size(); i++) {
                int[] now = q.poll();
                for (int[] nextInfo : adj.get(now[0])) {
                    int price = nextInfo[1];
                    int nextNode = nextInfo[0];
                    if (price + now[1] >= minCount[nextNode]) {
                        continue;
                    }

                    minCount[nextNode] = price + now[1];
                    q.offer(new int[]{nextNode, minCount[nextNode]});
                }

            }

            stops++;
        }

        return minCount[dst] == Integer.MAX_VALUE ? -1 : minCount[dst];
    }
}
