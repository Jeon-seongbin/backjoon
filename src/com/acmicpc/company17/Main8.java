package com.acmicpc.company17;

import java.io.*;
import java.util.StringTokenizer;

public class Main8 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] array = new int[count];
        int[] d = new int[count];
        for (int i = 0; i < count; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        d[0] = 1;

        for (int i = 1; i < count; i++) {
            d[i] = 1;
            for (int k = 0; k < i; k++) {
                if (array[k] < array[i] && d[i] <= d[k]) {
                    d[i] = d[k] + 1;
                }
            }
        }
        int max = 0;
        for (int i : d) {
            max = Math.max(max, i);
        }

        bw.write("" + max);
        bw.close();
        br.close();
    }
}
