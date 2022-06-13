package com.acmicpc.company28;

import java.io.*;
import java.util.StringTokenizer;

public class Main5 {
    public static int N, K;
    public static int[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        int computed = 0;
        for (int i = 0; i < K; i++) {
            computed += input[i];
        }
        int original = computed;
        int ans_cnt = 1;

        for (int i = K; i < N; i++) {
            computed += input[i];
            computed -= input[i - K];

            if (original < computed) {
                original = computed;
                ans_cnt = 1;
            } else if (original == computed) {
                ans_cnt++;
            }
        }

        if (original == 0) {
            System.out.println("SAD");
            return;
        }
        System.out.println("" +original + "\n" + ans_cnt);
    }
}
