package com.acmicpc.company9;

import java.io.*;

// https://www.acmicpc.net/problem/2163
public class Main9 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] userInputs = br.readLine().split(" ");

        int one = Integer.parseInt(userInputs[0]);
        int two = Integer.parseInt(userInputs[1]);
        int result = one * two - 1;
        bw.write("" + result);
        bw.flush();

    }
}
