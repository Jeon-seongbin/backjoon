package com.acmicpc.package17;

import java.io.*;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/14652
public class Main4 {
    public static int N, M, K = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //  첫째 줄에 관중석의 크기를 나타내는 N, M과 잃어버린 관중석 번호를 나타내는 K가 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (count == K) {
                    bw.write("" + i + " " + j);
                }
                count++;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
