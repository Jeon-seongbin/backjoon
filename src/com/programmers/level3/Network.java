package com.programmers.level3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Network {
    public static void main(String[] args) {
        solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;

        ArrayList<ArrayList<Integer>> a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            a.add(new ArrayList<>());
        }

        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[i].length; j++) {
                if (i == j) {
                    continue;
                }
                if (computers[i][j] == 1) {
                    a.get(i).add(j);
                    a.get(j).add(i);
                }

            }
        }

        boolean[] isVisited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (isVisited[i]) {
                continue;
            }
            answer++;
            queue.add(i);
            isVisited[i] = true;

            while (!queue.isEmpty()) {
                int now = queue.poll();

                for (int j = 0; j < a.get(now).size(); j++) {
                    int nextPoint = a.get(now).get(j);
                    if (isVisited[nextPoint]) {
                        continue;
                    }
                    queue.add(nextPoint);
                    isVisited[nextPoint] = true;
                }

            }

        }

        return answer;
    }
}
