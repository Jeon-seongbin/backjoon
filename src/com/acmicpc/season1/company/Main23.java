package com.acmicpc.season1.company;

import java.io.*;

public class Main23 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        BufferedWriter buf = new BufferedWriter(new OutputStreamWriter(System.out));

        int userInput = Integer.parseInt(bf.readLine());

        for(int i = 0 ; i < userInput ; i++){
            String a = bf.readLine();
            String[] ab = a.split(" ");
            buf.write(Integer.parseInt(ab[0]) +Integer.parseInt(ab[1]) + "\n");
        }
        buf.flush();
    }


}

