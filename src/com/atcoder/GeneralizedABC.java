package com.atcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GeneralizedABC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int i = Integer.parseInt(br.readLine());
        i += 64;
        for (int j = 65; j <= i; j++) {
            char c = (char) j;
            System.out.print(c);
        }
    }
}
