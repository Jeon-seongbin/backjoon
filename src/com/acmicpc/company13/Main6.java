package com.acmicpc.company13;

import java.io.*;
import java.util.StringTokenizer;

public class Main6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 저장
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        //총합
        int max = numbers[0];
        int sum = 0;

        // 값을 입력할때마다 최댓값을 구하고
        // 합이 음수가 나오면 0으로 초기화 한다
        for (int i = 0; i < n; i++) {
            sum += numbers[i];
            max = Math.max(max, sum);
            if (sum < 0) sum = 0;
        }


        bw.write("" + max);
        br.close();
        bw.close();
    }
}
