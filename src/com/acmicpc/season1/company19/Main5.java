package com.acmicpc.season1.company19;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main5 {

    public static int N = 0;
    public static int M = 0;
    public static int result = Integer.MAX_VALUE;
    public static int count = 0;
    public static int[] move = new int[100001];
    private static int[] parent = new int[100001];
    public static int[] dx = {-1, 1, 2};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        bfs();
        bw.write("" + result + "\n");
        bw.write("" + count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    // 방문 시간을 저장
    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(N);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            // current 방문 시간이 최소 시간보다 크면 뒤는 더 볼 필요 없음
            if (result < move[current]) {
                return;
            }

            // 현재 값이 목표치의 값인데
            // 현재 방문 시간이 최소 시간보다 작을 경우에 카운트
            if (move[current] <= result && current == M) {
                result = move[current];
                count++;
            }

            for (int i = 0; i < 3; i++) {
                int next = current;
                if (i == 2) {
                    next = next * dx[i];
                } else {
                    next = next + dx[i];
                }

                // 범위가 안쪽인 상황에서
                if (0 <= next && next <= 100000) {
                    // 다음 방문 할 곳에 방문하지 않았거나
                    // 이미 방문한 곳이어도 같은 시간에 방문했다면 (time[next] == time[now] + 1)
                    if (move[next] == 0 || move[next] == move[current] + 1) {
                        move[next] = move[current] + 1;
                        parent[next] = current;
                        queue.add(next);
                    }
                }
            }
        }
    }
}
