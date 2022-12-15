package com.acmicpc.package23;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main3 {
    public static int N = 0;
    public static int C = 0;
    public static int[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        input = new int[N];

        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(input);

        // 거리
        int lowLength = 1;
        int highLength = input[N - 1] - input[0] + 1;
        int ans = 0;

        while (lowLength <= highLength) {
            int cnt = 1;
            int prev = input[0];
            int mid = lowLength + (highLength - lowLength) / 2;

            for (int i = 1; i < N; i++) {
                if (input[i] - prev >= mid) {
                    prev = input[i];
                    cnt++;
                }
            }

            if (cnt >= C) {
                lowLength = mid + 1;
                ans = mid;
            } else {
                highLength = mid - 1;
            }
        }
        System.out.println(ans);

    }

}
