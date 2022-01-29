package com.company10;

import java.io.*;
import java.math.BigDecimal;

// https://www.acmicpc.net/problem/10829
public class Main6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BigDecimal userInput = new BigDecimal(br.readLine());

        String result = div(userInput);
        bw.write(result);
        bw.flush();

        bw.close();
        br.close();

    }

    static String div(BigDecimal a) {
        String result = "";
        if(BigDecimal.ONE.compareTo(a) < 0){
            result = div(a.divideToIntegralValue(new BigDecimal(2)));
        }

        result += a.remainder(new BigDecimal(2));
        return result;
    }
}
