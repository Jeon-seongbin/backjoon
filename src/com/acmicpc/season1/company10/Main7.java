package com.acmicpc.season1.company10;

import java.io.*;

// https://www.acmicpc.net/problem/2010
public class Main7 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        int sum = 0;
        int count1 = 0;
        for (int i = 0; i < count; i++) {
            sum += Integer.parseInt(br.readLine());
            if(i + 1 < count){
                count1++;
            }
        }

        bw.write(""+ (sum - count1));
        bw.flush();

        bw.close();
        br.close();
    }
}
