package com.company;

import java.io.*;

public class Main25 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        BufferedWriter buf = new BufferedWriter(new OutputStreamWriter(System.out));
        int userInput = Integer.parseInt(bf.readLine());
        int[] array = new int[1000001];

//        for (int i = 0; i < userInput; i++) {
//            array[i] = 0;
//        }

        for (int i = 0; i < userInput; i++) {
            int j = Integer.parseInt(bf.readLine());
            array[j]++;
        }


        for(int i=1; i<=1000000; i++) {
            int j = array[i];
            if (j == 0) {
                continue;
            }
            for (int z = 0; z < j; z++) {
                buf.write((i) + "\n");
            }
        }
        buf.flush();

        buf.close();
        bf.close();
    }
}
