package com.acmicpc.company23;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String hexInput = br.readLine();
        int decimal = Integer.parseInt(hexInput, 16);
        System.out.println(decimal);
    }
}
