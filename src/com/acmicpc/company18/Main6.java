package com.acmicpc.company18;

import java.io.*;
import java.util.*;

public class Main6 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[count + 1];
        int[] length = new int[count + 1];
        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i <= count; i++) {
            length[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && length[i] <= length[j]) {
                    length[i] = length[j] + 1;
                }
            }
        }

        for (int i : length) {
            if (max < i) {
                max = i;
            }
        }

        bw.write("" + max);
        bw.flush();
        br.close();
        bw.close();
    }
}

