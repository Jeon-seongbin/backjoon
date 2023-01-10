package com.acmicpc.season1.company23;

import java.io.*;
import java.util.StringTokenizer;

public class Main2 {
    public static int N, S;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());
        // 첫째 줄에 N (10 ≤ N < 100,000)과 S (0 < S ≤ 100,000,000)가 주어진다.
        N = Integer.parseInt(st.nextToken());

        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int count = 0;
        while (true) {
            if (S < sum) {
                sum -= arr[end];
                end++;
            } else if (sum == S) {
                count++;
                sum -= arr[end];
                end++;
            } else if (start == N) {
                break;
            } else {
                sum += arr[start];
                start++;
            }
        }
        bw.write("" + count);
        bw.flush();
        bw.close();
        br.close();
    }
}
