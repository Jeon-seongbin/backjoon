package com.paiza.d_class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class D213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigDecimal big = new BigDecimal(br.readLine());
        big = big.multiply(new BigDecimal(365));
        System.out.println(big);
    }
}
