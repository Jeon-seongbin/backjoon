package com.acmicpc.season1.company14;

import java.io.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int mondai = 0;

        while (true) {
            String userInput = br.readLine();
            if (userInput.equals("고무오리 디버깅 끝")) {
                break;
            }
            if (userInput.equals("고무오리")) {
                if(0 < mondai){
                    mondai--;
                }else{
                    mondai++;
                    mondai++;
                }
            }
            if (userInput.equals("문제")) {
                mondai++;
            }
        }
        if(mondai == 0){
            bw.write("고무오리야 사랑해");
        }else{
            bw.write("힝구");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
