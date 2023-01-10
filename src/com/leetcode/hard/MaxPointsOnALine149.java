package com.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine149 {
    public static void main(String[] args) {

    }

    public static int maxPoints(int[][] points) {
        int max = 0;

        for (int[] point1 : points) {
            Map<Double, Integer> slopeMap = new HashMap<>();

            for (int[] point2 : points) {
                if (point1 == point2) {
                    continue;
                }
                double slope = 0;
                if (point1[0] == point2[0]) {
                    slope = Double.POSITIVE_INFINITY;
                } else {
                    // slope (m) = (y2 - y1) / (x2 - x1)
                    slope = (point2[1] - point1[1]) / (double) (point2[0] - point1[0]);
                }
                slopeMap.put(slope, slopeMap.getOrDefault(slope, 0) + 1);
                max = Math.max(max, slopeMap.get(slope));
            }
        }
        return max + 1;
    }
}
