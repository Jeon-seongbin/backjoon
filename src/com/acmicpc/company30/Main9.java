package com.acmicpc.company30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        n /= 4;
        for (int i = 0; i < n; i++) {
            System.out.print("long ");
        }
        System.out.print("int");

    }
}
