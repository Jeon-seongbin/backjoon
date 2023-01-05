package com.leetcode.midium;

import java.util.Arrays;

public class MinimumNumberOfArrowsToBurstBalloons452 {
    public static void main(String[] args) {
        findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}});
    }

    public static int findMinArrowShots(int[][] points) {

        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int result = 1;

        int prev = 0;

        for (int curr = 1; curr < points.length; curr++) {
            if (points[curr][0] > points[prev][1]) {
                result++;
                prev = curr;
            }
        }

        return result;
    }
}
