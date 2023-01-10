package com.acmicpc.season1.company18;

import java.io.*;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1541
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        int sum = Integer.MAX_VALUE;

        while (st.hasMoreElements()) {
            int temp = 0;
            StringTokenizer addition = new StringTokenizer(st.nextToken(), "+");
            while (addition.hasMoreTokens()) {
                temp += Integer.parseInt(addition.nextToken());
            }

            if (sum == Integer.MAX_VALUE) {
                sum = temp;
            } else {
                sum -= temp;
            }
        }

        bw.write("" + sum);
        br.close();
        bw.close();
    }
}
