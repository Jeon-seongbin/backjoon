package com.acmicpc.season1.company30;

import java.io.*;
import java.util.StringTokenizer;

public class Main4 {
    public static int N;
    public static int[] input;
    public static int[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        input = new int[N + 1];
        sum = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + input[i];
        }

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            start--;
            int result = sum[end] - sum[start];
            bw.write("" + result + "\n");

        }

        bw.flush();
        bw.close();
        br.close();
    }
}
