package com.programmers.level3;

import java.util.*;


public class ReturnArmy {
    public static void main(String[] args) {
        solution(5, new int[][]{{1, 2}, {1, 4}, {2, 4}, {2, 5}, {4, 5}}, new int[]{1, 3, 5}, 5);
    }


    public static int[] solution(int n, int[][] roads, int[] sources, int destination) {
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];


            ArrayList<Integer> aList = hashMap.getOrDefault(a, new ArrayList<>());
            ArrayList<Integer> bList = hashMap.getOrDefault(b, new ArrayList<>());
            aList.add(b);
            bList.add(a);

            hashMap.put(a, aList);
            hashMap.put(b, bList);

        }

        boolean[] isVisited = new boolean[n + 1];
        int[] check = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            check[i] = Integer.MAX_VALUE;
        }

        Queue<Integer> q = new LinkedList<>();

        q.add(destination);
        isVisited[destination] = true;
        check[destination] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();

            ArrayList<Integer> next = hashMap.getOrDefault(now, new ArrayList<>());

            for (int i = 0; i < next.size(); i++) {

                int nextPoint = next.get(i);
                if (isVisited[nextPoint]) {
                    continue;
                }
                isVisited[nextPoint] = true;
                q.add(nextPoint);
                check[nextPoint] = check[now] + 1;
            }

        }
        ArrayList<Integer> result = new ArrayList<>();

        for (int s : sources) {
            if (check[s] == Integer.MAX_VALUE) {
                check[s] = -1;
            }
            result.add(check[s]);

        }

        return result.stream().mapToInt(i -> i).toArray();

    }

    public static int[] solution_TLE(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];


        int[][] map = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {

                map[i][j] = 100_000_000;
                if (i == j) {
                    map[i][j] = 0;
                }
            }
        }

        for (int[] road : roads) {
            map[road[0]][road[1]] = 1;
            map[road[1]][road[0]] = 1;
        }


        for (int k = 0; k < n + 1; k++) {
            for (int i = 0; i < n + 1; i++) {
                for (int j = 0; j < n + 1; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }


        ArrayList<Integer> a = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            int aa = map[destination][i];

            a.add(aa);

        }

        for (int i = 0; i < sources.length; i++) {
            int aa = a.get(sources[i] - 1);
            if (aa == 100_000_000) {
                aa = -1;
            }
            answer[i] = aa;
        }
        return answer;
    }
}
