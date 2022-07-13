package com.acmicpc.company30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10 {
    public static int N, S;
    public static int[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        input = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        long max = 0;
        for (int i = 0; i <= N - S; i++) {
            long sum = 0;
            for (int j = i; j < i + S; j++) {
                sum += input[j];
            }
            if (max < sum) {
                max = sum;
            }
        }

        System.out.println(max);
    }
}
