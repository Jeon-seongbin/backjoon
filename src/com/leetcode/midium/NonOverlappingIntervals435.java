package com.leetcode.midium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class NonOverlappingIntervals435 {
    public static void main(String[] args) {
        eraseOverlapIntervals(new int[][]
                {{1, 2}, {2, 3}, {3, 4}, {1, 3}}
        );
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int prev = 0;
        int count = 1;


        for (int i = 0; i < intervals.length; i++) {

            int left = intervals[i][0];
            int right = intervals[prev][1];

            if (left >= right) {
                count++;
                prev = i;
            }
        }
        return intervals.length - count;
    }


    public static int eraseOverlapIntervals1(int[][] intervals) {


        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o2.point1 - o1.point1;
            }
        });


        int kijun = -1;
        int result = 0;
        for (int i = 0; i < intervals.length; i++) {
            pq.add(new Point(intervals[i][0], intervals[i][1]));
            int temp = pq.peek().point1;
            if (kijun <= pq.peek().point1) {
                kijun = pq.peek().point1;
            } else {
                result++;
            }


        }
        return result;

    }

    static class Point {
        int point1;
        int point2;

        Point(int point1, int point2) {
            this.point1 = point1;
            this.point2 = point2;
        }
    }

}
