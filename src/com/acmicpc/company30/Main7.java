package com.acmicpc.company30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main7 {
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        N = Integer.parseInt(br.readLine());

        String[] strs = br.readLine().split(" ");
        N = Integer.parseInt(strs[0]);

        int start = 1;
        int end = N;
        int answer = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int sum = mid * (mid + 1) / 2;

            if (sum <= N) {
                start = mid + 1;
                answer = mid;
            } else {
                end = mid - 1;
            }
        }
        System.out.println("" + answer);
    }
}
