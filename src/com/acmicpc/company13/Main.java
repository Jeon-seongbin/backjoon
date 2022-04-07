package com.acmicpc.company13;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        //데이터 구성
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        //문제풀이
        String result = solution(queue, K);


        //문자열 처리
        result = result.substring(0, result.length() - 2);
        result += ">";

        bw.write("<" + result);

        bw.flush();
        bw.close();
        br.close();

    }

    static String solution(Queue<Integer> queue, int K) {
        String result = "";
        while (!queue.isEmpty()) {
            // K번 까지는 큐에서 빼서 뒷쪽에 붙여줌
            for (int i = 0; i < K - 1; i++) {
                queue.offer(queue.poll());
            }
            //K번째 되는 것은 큐에서 뺌
            result += (String.valueOf(queue.poll()) + ", ");
        }
        return result;
    }

}
