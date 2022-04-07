package com.acmicpc.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main22 {
    static int[] dp = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        int userInput = Integer.parseInt(bf.readLine());

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < dp.length; i++) {
            dp[i] = -1;
        }
        int result = go(userInput);
        System.out.println(result);
    }

    static int go(int userInput) {
        if (dp[userInput] == -1) {
            dp[userInput] = (go(userInput - 1) + go(userInput - 2)) % 15746;
        }
        return dp[userInput];
    }
}
