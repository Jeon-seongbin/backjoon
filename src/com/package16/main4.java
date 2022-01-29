package com.package16;

import java.io.*;

public class main4 {
    public static void main(String[] args) throws IOException {
        int mod = 1000000000;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int userInput = Integer.parseInt(br.readLine());
        long[][] dp = new long[userInput + 1][10];

        for (int i = 1; i < 10; i++)
            dp[1][i] = 1;

        for (int i = 2; i <= userInput; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0)
                    dp[i][j] = dp[i - 1][j + 1];
                else if (j == 9)
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                dp[i][j] %= mod;
            }
        }
        long answer = 0;
        for (int i = 0; i < 10; i++)
            answer += dp[userInput][i];

        System.out.println(answer % mod);

        bw.flush();
        bw.close();
        br.close();
    }
}
