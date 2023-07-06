package com.programmers.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CutElectronicLine {
    public static void main(String[] args) {
        solution(4, new int[][]{
                {1, 2}, {2, 3}, {3, 4}
        });

    }

    public static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;


        for (int index = 1; index <= n; index++) {
            boolean[] isVisited = new boolean[n + 1];

            ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                arrayList.add(new ArrayList<>());
            }

            for (int i = 0; i < wires.length; i++) {
                if (index == i + 1) {
                    continue;
                }
                int leftPoint = wires[i][0];
                int rightPoint = wires[i][1];

                arrayList.get(leftPoint).add(rightPoint);
                arrayList.get(rightPoint).add(leftPoint);
            }

            ArrayList<Integer> electricPoint = new ArrayList<>();


            for (int i = 1; i <= n; i++) {
                if (isVisited[i]) {
                    continue;
                }
                electricPoint.add(0);
                Queue<Integer> q = new LinkedList<>();
                isVisited[i] = true;
                q.add(i);

                while (!q.isEmpty()) {
                    int now = q.poll();

                    for (int nextIndex = 0; nextIndex < arrayList.get(now).size(); nextIndex++) {
                        int nextPoint = arrayList.get(now).get(nextIndex);

                        if (isVisited[nextPoint]) {
                            continue;
                        }
                        isVisited[nextPoint] = true;
                        q.add(nextPoint);
                        int nowCount = electricPoint.get(electricPoint.size() - 1);
                        electricPoint.set(electricPoint.size() - 1, nowCount + 1);

                    }
                }

            }
            if (2 <= electricPoint.size()) {
                int res = Math.abs(electricPoint.get(0) - electricPoint.get(1));
                answer = Math.min(res, answer);
            }

        }

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

}
