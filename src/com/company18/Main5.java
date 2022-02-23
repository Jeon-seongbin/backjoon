package com.company18;

import java.io.*;

public class Main5 {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(br.readLine());
        int j = Integer.parseInt(br.readLine());

        if (i == 2 && j == 18) {
            bw.write("Special");
        } else if (i < 2) {
            bw.write("Before");
        } else if (i > 2) {
            bw.write("After");
        } else {
            if (j < 18) {
                bw.write("Before");
            } else if (19 < j) {
                bw.write("After");
            }
        }
        bw.flush();
        bw.close();
    }
}
