package com.acmicpc.season1.company30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static int[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 첫째 줄에 조카의 수 M (1 ≤ M ≤ 1,000,000), 과자의 수 N (1 ≤ N ≤ 1,000,000)이 주어진다.
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        input = new int[N];

        // 둘째 줄에 과자 N개의 길이 L1, L2, ..., LN이 공백으로 구분되어 주어진다. 과자의 길이는 (1 ≤ L1, L2, ..., LN ≤ 1,000,000,000) 를 만족한다
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());

        }
        Arrays.sort(input);

        long start = 1;
        long end = input[N - 1];

        long result = 0;


        while (start <= end) {
            long mid = start + (end - start) / 2;
            long sum = 0;
            for (int i = 0; i < N; i++) {
                sum += (input[i] / mid);
            }

            if (M <= sum) {
                start = mid + 1;
                result = mid;

            } else {
                end = mid - 1;
            }


        }
        System.out.println(result);
    }
}
