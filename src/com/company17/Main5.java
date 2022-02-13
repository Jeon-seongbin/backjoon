package com.company17;

import java.io.*;
import java.util.StringTokenizer;

public class Main5 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int inputCount = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        int[] numbers = new int[inputCount + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= inputCount; i++) {
            numbers[i] = numbers[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            int ii = Integer.parseInt(st.nextToken());
            int jj = Integer.parseInt(st.nextToken());
            bw.write("" + (numbers[jj] - numbers[ii - 1]) + "\n");
        }
        bw.close();
        br.close();
    }
}
