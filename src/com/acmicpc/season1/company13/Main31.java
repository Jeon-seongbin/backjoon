package com.acmicpc.season1.company13;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main31 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<Integer> queue = new PriorityQueue<>();
        int userInput = Integer.parseInt(st.nextToken());

        for (int i = 0; i < userInput; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < userInput; j++) {
                int num = Integer.parseInt(st.nextToken());

                // 입력받은 수 만큼 유지 하는게 포인트
                if (queue.size() == userInput) {
                    int peek = queue.peek();
                    // 들어 있는 값이 작으면
                    if (peek < num) {

                        // 빼내고
                        queue.poll();

                        // 값을 추가
                        queue.offer(num);
                    }
                } else {
                    queue.offer(num);
                }
            }
        }

        bw.write("" + queue.poll());
        bw.flush();
        bw.close();
        br.close();
    }
}
