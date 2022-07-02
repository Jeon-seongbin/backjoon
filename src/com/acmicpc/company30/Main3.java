package com.acmicpc.company30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3 {
    public static int N, M;
    public static int start, end, max;
    public static boolean[] visited;
    public static ArrayList<ArrayList<Point1939>> link = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            link.add(new ArrayList<>());
        }
        max = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            link.get(a).add(new Point1939(b, c));
            link.get(b).add(new Point1939(a, c));
            max = Math.max(c, max);
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int right = max;
        int left = 0;

        // 코스트의 중간을 잡고
        while (left <= right) {
            int mid = left + (right - left) / 2;
            visited = new boolean[N + 1];
            if (bfs(start, end, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        System.out.println(right);
    }

    public static boolean bfs(int start, int end, int cost) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (end == now) {
                return true;
            }

            for (Point1939 next : link.get(now)) {
                if (!visited[next.destination] && cost <= next.cost) {
                    visited[next.destination] = true;
                    queue.add(next.destination);
                }
            }
        }
        return false;
    }
}

class Point1939 {
    int destination;
    int cost;

    Point1939(int destination, int cost) {
        this.destination = destination;
        this.cost = cost;
    }
}
