package com.acmicpc.season1.company30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main6 {
    public static int N, K;
    public static int[] input;
    public static int[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        input = new int[N + 1];
        sum = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            if (i == 1) {
                sum[i] = input[i];
            } else {
                sum[i] = input[i] + sum[i - 1];
            }
        }

        int min = Integer.MIN_VALUE;

        for (int i = K; i <= N; i++) {
            min = Math.max(min, sum[i] - sum[i - K]);
        }

        System.out.println(min);
    }
}
