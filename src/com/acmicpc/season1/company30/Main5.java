package com.acmicpc.season1.company30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main5 {
    public static int N, K;
    public static int[] input;
    public static int[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N과 K가 한 개의 공백을 사이에 두고 순서대로 주어진다.
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        input = new int[N];
        sum = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for (int i = 0; i < N - K; i++) {
            int sum = 0;
            for (int j = i; i < i + K; i++) {
                sum += input[j];
            }
            result = Math.max(result, sum);
        }

        System.out.println(result);
    }
}
