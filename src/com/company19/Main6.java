package com.company19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main6 {
    public static void main(String[] args) throws IOException {
        int max = 1000000;
        int[] time = new int[max];
        int[] dist = new int[max];

        boolean[] visit = new boolean[max];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        visit[x] = true;

        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        while (!q.isEmpty()) {
            int n = q.remove();

            if (n == y) {
                break;
            }

            if (n + 1 < max && !visit[n + 1]) {
                visit[n + 1] = true;
                time[n + 1] = time[n] + 1;
                dist[n + 1] = n;
                q.add(n + 1);
            }

            if (0 <= n - 1 && !visit[n - 1]) {
                visit[n - 1] = true;
                time[n - 1] = time[n] + 1;
                dist[n - 1] = n;
                q.add(n - 1);
            }

            if (n * 2 < max && !visit[n * 2]) {
                visit[n * 2] = true;
                time[n * 2] = time[n] + 1;
                dist[n * 2] = n;
                q.add(n * 2);
            }
        }

        Stack<Integer> stack = new Stack<>();
        stack.add(y);
        int tempY = y;

        while (tempY != x) {
            tempY = dist[tempY];
            stack.add(tempY);
        }

        System.out.println(time[y]);
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            System.out.print(temp + " ");
        }
        System.out.println();
    }
}