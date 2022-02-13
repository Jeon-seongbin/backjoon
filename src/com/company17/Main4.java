package com.company17;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main4{
    public static long d[][];
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        d = new long[n+1][10];
        for (int i = 0; i <= 9; i++){
            d[1][i] = 1;
        }
        for (int i = 2; i <= n; i++){
            for (int j = 0; j <= 9; j++){
                for (int k = 0; k <= j; k++){
                    d[i][j] += d[i-1][k];
                    d[i][j] %= 10007;
                }
            }
        }
        long sum = 0;
        for (int i = 0; i <= 9; i++){
            sum += d[n][i];
            sum %= 10007;
        }
        System.out.println(sum);
    }
}