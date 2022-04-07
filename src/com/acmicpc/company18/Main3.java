package com.acmicpc.company18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


public class Main3 {
    static ArrayList<Integer> numbers = new ArrayList<Integer>();
    static int[] dp = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        ans(n);
        bw.write(dp[n] + "\n");
        bw.flush();
        bw.close();
    }

    public static void ans(int n) {
        dp[1] = 1;
        for (int top = 2; top <= n; top++) {
            int min = 100001;
            for (int bottom = 1; bottom <= (int) top / 2; bottom++) {
                if (bottom * bottom == top) { // i가 어떤수의 제곱인 경우는 dp가 1이다
                    min = 1;
                    break;
                } else {
                    min = Math.min(min, dp[bottom] + dp[top - bottom]);
                }
            }
            dp[top] = min;
        }
        return;
    }
}
