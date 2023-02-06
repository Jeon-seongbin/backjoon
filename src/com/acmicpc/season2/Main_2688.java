package com.acmicpc.season2;

import java.io.*;
import java.math.BigDecimal;

public class Main_2688 {
    public static void main(String[] args) throws IOException {
        BigDecimal[][] temp = new BigDecimal[65][10];

        temp[0][0] = BigDecimal.ONE;
        temp[0][1] = BigDecimal.ONE;
        temp[0][2] = BigDecimal.ONE;
        temp[0][3] = BigDecimal.ONE;
        temp[0][4] = BigDecimal.ONE;
        temp[0][5] = BigDecimal.ONE;
        temp[0][6] = BigDecimal.ONE;
        temp[0][7] = BigDecimal.ONE;
        temp[0][8] = BigDecimal.ONE;
        temp[0][9] = BigDecimal.ONE;

        temp[1][0] = BigDecimal.valueOf(10);
        temp[1][1] = BigDecimal.valueOf(9);
        temp[1][2] = BigDecimal.valueOf(8);
        temp[1][3] = BigDecimal.valueOf(7);
        temp[1][4] = BigDecimal.valueOf(6);
        temp[1][5] = BigDecimal.valueOf(5);
        temp[1][6] = BigDecimal.valueOf(4);
        temp[1][7] = BigDecimal.valueOf(3);
        temp[1][8] = BigDecimal.valueOf(2);
        temp[1][9] = BigDecimal.valueOf(1);

        for (int i = 2; i <= 64; i++) {
            for (int j = 9; j >= 0; j--) {
                if (j == 9) {
                    temp[i][j] = BigDecimal.ONE;
                    continue;
                }
                temp[i][j] = temp[i - 1][j].add(temp[i][j + 1]);
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int userInput = Integer.parseInt(br.readLine());

        for (int i = 0; i < userInput; i++) {
            int input = Integer.parseInt(br.readLine());
            bw.write(temp[input][0].toString());
            bw.write("\n");
        }
        bw.flush();


    }
}
