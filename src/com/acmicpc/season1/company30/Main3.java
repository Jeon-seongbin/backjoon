package com.acmicpc.season1.company30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3 {
    public static int left = 0, right = 0;
    public static int N, M;

    public static int start, end;
    public static boolean[] isVisited;
    public static ArrayList<ArrayList<Point1939>> arrayList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + 1; i++) {
            arrayList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arrayList.get(a).add(new Point1939(b, c));
            arrayList.get(b).add(new Point1939(a, c));
            right = Math.max(right, c);
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        // cost 크기를 체크
        while (left <= right) {
            int mid = left + (right - left) / 2;
            isVisited = new boolean[N + 1];
            if (bfs(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(right);
    }

    public static boolean bfs(int cost) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        isVisited[start] = true;

        while (!queue.isEmpty()) {
            int nowPoint = queue.poll();
            if (nowPoint == end) {
                return true;
            }
            ArrayList<Point1939> nextPoints = arrayList.get(nowPoint);
            for (Point1939 nextPoint : nextPoints) {
                if (isVisited[nextPoint.nextPoint]) {
                    continue;
                }
                if (cost <= nextPoint.cost) {
                    queue.add(nextPoint.nextPoint);
                    isVisited[nextPoint.nextPoint] = true;
                }
            }
        }
        return false;
    }
}

class Point1939 {
    int nextPoint;
    int cost;

    public Point1939(int nextPoint, int cost) {
        this.nextPoint = nextPoint;
        this.cost = cost;
    }
}
