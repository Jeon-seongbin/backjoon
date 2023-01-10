package com.acmicpc.season1.company23;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int N, S;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 첫째 줄에 N (10 ≤ N < 100,000)과 S (0 < S ≤ 100,000,000)가 주어진다.
        N = Integer.parseInt(st.nextToken());

        S = Integer.parseInt(st.nextToken());

        // 이 수열에서 연속된 수들의 부분합 중에 그 합이 S 이상이 되는 것 중, 가장 짧은 것의 길이를 구하는 프로그램을 작성하시오.
        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;
        int end = 0;

        while (true) {
            if (S <= sum) {
                sum -= arr[end];
                result = Math.min(result, start - end);
                end++;
            } else if (start == N) {
                break;
            } else {
                sum += arr[start];
                start++;
            }
        }


//        int sum = 0;
//        int left = 0;
//        int right = 0;
//        while (true) {
//            if (S <= sum) {
//                sum -= arr[left];
//                result = Math.min(result, (right - left));
//                left++;// 부분합 최소 길이 갱신
//            } else if (right == N) {
//                break;
//            } else {
//                sum += arr[right];
//                right++;
//
//            }
//        }

        if (result == Integer.MAX_VALUE) {
            bw.write("0");
        } else {
            bw.write("" + result);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
