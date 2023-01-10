package com.acmicpc.season1.company10;

import java.io.*;

public class Main9 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count1 = Integer.parseInt(br.readLine());
        int count2 = Integer.parseInt(br.readLine());

        int sabun = -1 * (count1 - count2);
        bw.write("" + (count2 + sabun));
        bw.flush();

        bw.close();
        br.close();
    }
}
