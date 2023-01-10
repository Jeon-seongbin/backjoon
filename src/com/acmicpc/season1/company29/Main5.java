package com.acmicpc.season1.company29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main5 {
    public static int K, N;
    public static int[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        input = new int[K];
        long start = 1;
        long end = 0;

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            input[i] = Integer.parseInt(st.nextToken());
            end = Math.max(input[i], end);
        }
        Arrays.sort(input);

        while (start <= end) {
            long mid = start + (end - start) / 2;
            long sum = 0;
            for (int i = 0; i < K; i++) {
                sum += (input[i] / mid);
            }

            /*
             *  [upper bound 형식]
             *
             *  mid길이로 잘랐을 때의 개수가 만들고자 하는 랜선의 개수보다 작다면
             *  자르고자 하는 길이를 줄이기 위해 최대 길이를 줄인다.
             *  그 외에는 자르고자 하는 길이를 늘려야 하므로 최소 길이를 늘린다.
             */
            if (sum < N) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }

        System.out.println(end);


    }
}
