package com.acmicpc.company19;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/13913
public class Main6 {

    static int[] map = new int[1000000];
    static int[] origin = new int[1000000];
    static boolean[] visited = new boolean[1000000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);

        visited[N] = true;
        while (!queue.isEmpty()) {
//            1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
            int n = queue.remove();
            if (n + 1 < 1000000 && !visited[n + 1]) {
                map[n + 1] = map[n] + 1;
                origin[n + 1] = n;
                visited[n + 1] = true;
                queue.offer(n + 1);
            }

            if (0 <= n - 1 && !visited[n - 1]) {
                map[n - 1] = map[n] + 1;
                origin[n - 1] = n;
                visited[n - 1] = true;
                queue.offer(n - 1);
            }
            if (n * 2 < 1000000 && !visited[n * 2]) {
                map[n * 2] = map[n] + 1;
                origin[n * 2] = n;
                visited[n * 2] = true;
                queue.offer(n * 2);
            }
        }

        System.out.println(map[K]);

        Stack<Integer> stack = new Stack<>();
        stack.add(K);
        int tempY = K;

        while (tempY != N) {
            tempY = origin[tempY];
            stack.add(tempY);
        }

        while (!stack.isEmpty()) {
            int temp = stack.pop();
            System.out.print(temp + " ");
        }
        br.close();
    }
}