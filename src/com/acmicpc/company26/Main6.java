package com.acmicpc.company26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Main6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigDecimal bigDecimal = new BigDecimal(br.readLine());

        bigDecimal = bigDecimal.multiply(new BigDecimal(12));
        System.out.println(bigDecimal);
        br.close();
    }
}
