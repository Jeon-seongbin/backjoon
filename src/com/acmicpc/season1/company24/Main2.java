package com.acmicpc.season1.company24;

import java.io.*;
import java.util.StringTokenizer;

public class Main2 {
    public static int[] arr;
    public static int[] cnt = new int[100001];
    public static int N;
    public static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int count = 0;

        while (start < N) {
            if (cnt[arr[start]] != K) {
                cnt[arr[start]]++;
                start++;
            } else {
                cnt[arr[end]]--;
                end++;
            }
            count = Math.max(start - end, count);
        }

        bw.write("" + count);
        bw.flush();
        bw.close();
        br.close();
    }
}
