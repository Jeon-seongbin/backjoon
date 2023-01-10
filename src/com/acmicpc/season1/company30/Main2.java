package com.acmicpc.season1.company30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
    public static int N;
    public static int[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);

        int start = 0;
        int end = N - 1;
        long resultAbs = Math.abs(input[start] + input[end]);

        long resultStart = input[start];
        long resultEnd = input[end];

        while (start < end) {
            long sum = input[start] + input[end];

            if (Math.abs(sum) < resultAbs) {
                resultAbs = Math.abs(sum);
                resultStart =  input[start];
                resultEnd = input[end];
            }

            if (0 < sum) {
                end--;
            } else {
                start++;
            }
        }

        System.out.println(resultStart + " " + resultEnd);

    }
}
