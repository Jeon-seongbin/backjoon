package com.acmicpc.season1.company28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main4 {
    public static int N;
    public static int[] result, input;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        input = new int[N];
        result = new int[2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);

        int left = 0;
        int right = N - 1;
        while (left < right) {
            int temp = input[left] + input[right];

            if (Math.abs(temp) < min) {
                min = Math.abs(temp);
                result[0] = input[left];
                result[1] = input[right];
            }
            if (0 < temp) {
                right--;
            } else {
                left++;

            }
        }
        System.out.println(result[0] + " " + result[1]);

    }
}
