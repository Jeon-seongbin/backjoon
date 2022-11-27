package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class TheKWeakestRowsInAMatrix1337 {
    public static void main(String[] args) {
        kWeakestRows(new int[][]
                {
                        {1, 1, 0, 0, 0},
                        {1, 1, 1, 1, 0},
                        {0, 0, 0, 0, 0},
                        {1, 1, 0, 0, 0},
                        {1, 1, 1, 1, 1}
                }, 3);
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) count++;
            }
            map.put(i, count);
        }
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(k)
                .map(Map.Entry::getKey)
                .mapToInt(it -> it)
                .toArray();

    }
}
