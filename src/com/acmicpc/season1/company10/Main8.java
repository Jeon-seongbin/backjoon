package com.acmicpc.season1.company10;

import java.io.*;

public class Main8 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            int userInput = Integer.parseInt(br.readLine());
            String write = "0";
            int powCount = 1;

            while (true) {

                if(userInput == 1 || userInput == 2){
                    write = "1";
                    break;
                }
                if (Math.pow(2, powCount) <= userInput) {
                    if(Math.pow(2, powCount) == userInput){
                        write = "1";
                        break;

                    }
                    powCount++;
                }else{
                    write = "0";
                    break;
                }
            }
            bw.write(write+"\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }
}
