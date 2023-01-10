package com.acmicpc.season1.package16;

import java.io.*;


public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int userInput = Integer.parseInt(br.readLine());
        long[] size = new long[91];
        size[0] = 0;
        size[1] = 1;
        size[2] = 1;
        size[3] = 2;
        size[4] = 3;


        for (int i = 5; i <= userInput; i++) {
            size[i] = size[i - 1] + size[i - 2];


       }
		bw.write("" + size[userInput]);
        bw.flush();
        bw.close();
        br.close();
    }
}
