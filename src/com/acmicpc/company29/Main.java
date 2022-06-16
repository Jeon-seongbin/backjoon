package com.acmicpc.company29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int N;
    public static int k;
    public static int[] map;

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        long start = 0;
        long end = k;
        long result = 0;

        while (start <= end) {
            long mid = start + (end - start) / 2;

            long count = 0;
            for (int i = 1; i <= N; i++) {
                count += Math.min(N, mid / i);
            }

            if (count >= k) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
    System.out.println(result);
    }
}
