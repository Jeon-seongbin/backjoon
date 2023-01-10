package com.acmicpc.season1.company23;

import java.io.*;
import java.util.StringTokenizer;

public class Main5 {
    public static int N = 0, K = 0;
    public static boolean[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new boolean[N + 1];

        int count = 0;
        int result = 0;
        for (int i = 2; i <= N; i++) {
            if(result != 0){
                break;
            }
            for (int j = 1; j < N; j++) {

                if (N < i * j) {
                    continue;
                }
                if (arr[i * j] == true) {
                    continue;
                }
                count++;
                arr[i * j] = true;
                if (count == K) {
                    result = i * j;
                    break;
                }
            }
        }

        bw.write("" + result);
        bw.flush();
        bw.close();
        br.close();

    }
}
