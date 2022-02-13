package com.company17;

import java.io.*;

public class Main2 {


    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int userInput = Integer.parseInt(br.readLine());

        int[] tile = new int[1001];
        tile[0] = 0;
        tile[1] = 1;
        tile[2] = 3;
//        tile[3] = 5;
//        tile[4] = 11;
//        tile[5] = 22;

        for (int i = 3; i <= userInput; i++) {
            tile[i] = (tile[i - 1] + 2 * tile[i - 2]) % 10007;
//            tile[i] = (tile[i - 1] + 2 * tile[i - 2]) % 10007;
        }
        bw.write("" + tile[userInput]);

        bw.close();
        br.close();

    }
}
