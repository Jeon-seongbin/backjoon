package com.leetcode.midium;

import java.util.PriorityQueue;

public class EliminateMaximumNumberOfMonsters1921 {
    public static void main(String[] args) {
        int result = eliminateMaximum(new int[]{3, 2, 4}, new int[]{5, 3, 2});
        System.out.println(result);
    }


    public static int eliminateMaximum(int[] dist, int[] speed) {
        PriorityQueue<Double> timeTaken = new PriorityQueue<Double>();

        for (int i = 0; i < dist.length; i++) {
            timeTaken.offer(dist[i] / (speed[i] * 1.0));
        }
        int time = 0;
        while (!timeTaken.isEmpty()) {
            double timeCurr = timeTaken.poll();
            if (timeCurr <= time) {
                return time;
            }
            time++;
        }

        return time;

    }
}
