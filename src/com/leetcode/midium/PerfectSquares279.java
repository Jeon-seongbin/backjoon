package com.leetcode.midium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class PerfectSquares279 {
    public static void main(String[] args) {

    }

    public static int numSquares1(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static int numSquares2(int n) {
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> isVisited = new HashSet<>();

        queue.add(0);
        isVisited.add(0);

        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int previousLevel = queue.size();
            for (int index = 0; index < previousLevel; index++) {
                int now = queue.poll();
                for (int square = 1; square * square <= n - now; square++) {

                    int next = now + square * square;
                    if (n < next || isVisited.contains(next)) {
                        continue;
                    }
                    if (n == next) {
                        return level;
                    } else {
                        isVisited.add(next);
                        queue.add(next);
                    }
                }
            }
        }
        return -1;
    }
}
