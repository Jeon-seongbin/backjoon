package com.company17;

import java.io.*;
import java.util.StringTokenizer;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int userInput = Integer.parseInt(st.nextToken());

        long[][] a = new long[2001][2001];

        a[1][0] = 1;
        a[1][1] = 1;
        a[1][2] = 1;
        a[1][3] = 1;
        a[1][4] = 1;
        a[1][5] = 1;
        a[1][6] = 1;
        a[1][7] = 1;
        a[1][8] = 1;
        a[1][9] = 1;

        for (int i = 2; i <= userInput; i++) {

            for (int j = 0; j < 2001; j++) {
                if (j == 0) {
                    a[i][j] = 1;
                } else {
                    if(a[i - 1][j] == 0){
                        break;
                    }
                    a[i][j] = (a[i - 1][j] + a[i][j - 1]) % 10007;
                }
            }
        }
        long sum = 0;
        for (int k = 0; k < 2001; k++) {
            if (a[userInput][k] == 0) {
                break;
            }
            sum += a[userInput][k];
        }
        bw.write("" + sum % 10007);
//        a[2][0] = 10;
//        a[2][1] = 9;
//        a[2][2] = 8;
//        a[2][3] = 7;
//        a[2][4] = 6;
//        a[2][5] = 5;
//        a[2][6] = 4;
//        a[2][7] = 3;
//        a[2][8] = 2;
//        a[2][9] = 1;

//        a[3][0] = 10;
//        a[3][1] = 55;
//        a[3][2] = 45;
//        a[3][3] = 36;
//        a[3][4] = 45;
//        a[3][5] = 36;
//        a[3][6] = 28;
//        a[3][7] = 21;
//        a[3][8] = 15;
//        a[3][9] = 10;
//        a[3][10] = 6;
//        a[3][11] = 3;
//        a[3][12] = 1;
//
//        for (int i = 2; i <= userInput; i++) {
//            for (int j = 0; j < 2001; j++) {
//                if (j == 0) {
//////                    a[i][j] = 10;
////                } else if (j == 1) {
//                    long sum = 0;
//                    for (int k = 0; k < 2001; k++) {
//                        if (a[i - 1][k] == 0) {
//                            break;
//                        }
//                        sum += a[i - 1][k];
//                    }
//                    a[i][j] = sum % 10007;
//
//                } else {
//                    if (a[i][j - 1] - a[i - 1][j - 1] == 0) {
//                        break;
//                    }
//                    a[i][j] = (a[i][j - 1] - a[i - 1][j - 1]) % 10007;
//
//                }
//            }
//        }
//
//        long sum = 0;
//        for (int k = 0; k < 2001; k++) {
//            if (a[userInput][k] == 0) {
//                break;
//            }
//            sum += a[userInput][k];
//        }


        bw.close();
        br.close();
    }
}
