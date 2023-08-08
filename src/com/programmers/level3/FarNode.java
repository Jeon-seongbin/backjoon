package com.programmers.level3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FarNode {
    public static void main(String[] args) {
        solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});
    }

    static class Point {
        int to;
        int distance;

        Point(int to, int distance) {
            this.to = to;
            this.distance = distance;
        }
    }

    public static int solution(int n, int[][] edge) {
        int answer = 0;
        int temp = Integer.MIN_VALUE;

        boolean[] isVisited1 = new boolean[n + 1];
        int[] isVisited = new int[n + 1];
        ArrayList<ArrayList<Point>> a = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            a.add(new ArrayList<>());
        }

        for (int i = 0; i < edge.length; i++) {
            a.get(edge[i][0]).add(new Point(edge[i][1], 1));
            a.get(edge[i][1]).add(new Point(edge[i][0], 1));
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        isVisited[1] = 1;
        isVisited1[1] = true;
        while (!q.isEmpty()) {
            int nowPoint = q.poll();

            for (int i = 0; i < a.get(nowPoint).size(); i++) {
                Point nextPoint = a.get(nowPoint).get(i);

                int nextPointIndex = nextPoint.to;
                if (isVisited[nowPoint] + isVisited[nextPointIndex] < isVisited[nextPointIndex]) {
                    continue;
                }
                if (isVisited1[nextPointIndex]) {
                    continue;
                }

                isVisited1[nextPointIndex] = true;
                isVisited[nextPointIndex] = isVisited[nowPoint] + isVisited[nextPointIndex] + 1;
                q.add(nextPointIndex);

                // new Point(nextPointIndex, isVisited[nextPointIndex]);


            }
        }

        for (int i = 1; i < n + 1; i++) {
            temp = Math.max(isVisited[i], temp);
        }

        for (int i = 1; i < n + 1; i++) {
            if (isVisited[i] == temp) {
                answer++;
            }
        }
        return answer;


    }
}
