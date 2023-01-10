package com.acmicpc.season1.company13;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //데이터 구성
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        int cnt = 0;
        boolean check = true;

        while (!queue.isEmpty()) {
            if (check) {
                // -1 을 해줘야 값이 제대로 나옴..
                for (int i = 0; i < K - 1; i++) {
                    queue.offerLast(queue.pollFirst());
                }
                bw.write("" + queue.pollFirst());
                bw.write("\n");

            } else {
                // -1 을 해줘야 값이 제대로 나옴..
                for (int i = 0; i < K - 1; i++) {
                    queue.offerFirst(queue.pollLast());
                }
                bw.write("" + queue.pollLast());
                bw.write("\n");
            }

            cnt++;
            if (cnt == M) {
                check = !check;
                cnt = 0;
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
