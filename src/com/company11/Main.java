package com.company11;

import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        char[] origin = br.readLine().toCharArray();
        char[] changed = br.readLine().toCharArray();


        boolean ischanged = true;


        for (int c = 0; c < count; c++) {
            for (int i = 0; i < origin.length; i++) {
                if (origin[i] == '0') {
                    origin[i] = '1';
                } else {
                    origin[i] = '0';
                }
            }
        }

        for (int i = 0; i < origin.length; i++) {
            if (origin[i] != changed[i]) {
                ischanged = false;
                break;
            }

        }

        if (ischanged) {
            bw.write("Deletion succeeded");
        } else {

            bw.write("Deletion failed");
        }


        bw.flush();

        bw.close();
        br.close();
    }

}