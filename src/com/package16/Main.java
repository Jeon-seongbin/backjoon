package com.package16;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int userInput = Integer.parseInt(br.readLine());
        int result = sol(userInput);
        bw.write("" + result);

        bw.flush();
        bw.close();
        br.close();
    }

    static public int sol(int userInput) {
        int[] fiboCase = new int[46];
        fiboCase[0] = 0;
        fiboCase[1] = 1;
        fiboCase[2] = 1;
        fiboCase[3] = 2;
        for (int i = 4; i < userInput + 1; i++) {
            fiboCase[i] = fiboCase[i - 1] + fiboCase[i - 2];
        }
        return fiboCase[userInput];

    }
}
