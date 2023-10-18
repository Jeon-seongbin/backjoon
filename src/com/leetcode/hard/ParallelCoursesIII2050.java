package com.leetcode.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ParallelCoursesIII2050 {
    public static void main(String[] args) {
        minimumTime(9, new int[][]{
                        {2, 7},
                        {2, 6},
                        {3, 6},
                        {4, 6},
                        {7, 6},
                        {2, 1},
                        {3, 1},
                        {4, 1},
                        {6, 1},
                        {7, 1},
                        {3, 8},
                        {5, 8},
                        {7, 8},
                        {1, 9},
                        {2, 9},
                        {6, 9},
                        {7, 9}
                }

                , new int[]{9, 5, 9, 5, 8, 7, 7, 8, 4});
    }

    public static int minimumTime(int n, int[][] relations, int[] time) {
        int[] inDegree = new int[n];
        int[] maxTime = new int[n];

        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(new ArrayList<>());
        }

        for (int[] relation : relations) {
            arrayList.get(relation[0] - 1).add(relation[1] - 1);
            inDegree[relation[1] - 1]++;
        }


        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
                maxTime[i] = time[i];
            }
        }

        while (!q.isEmpty()) {
            int nowPoint = q.poll();

            for (int i = 0; i < arrayList.get(nowPoint).size(); i++) {
                int nextPoint = arrayList.get(nowPoint).get(i);

                inDegree[nextPoint]--;

                maxTime[nextPoint] = Math.max(maxTime[nextPoint] , maxTime[nowPoint] + time[nextPoint]);
                if (inDegree[nextPoint] == 0) {
                    q.add(nextPoint);
                }
            }
        }


        int result = 0;
        for(int m : maxTime){
            result = Math.max(result, m);
        }

        return result;
    }
}
