package com.acmicpc.company11;

import java.io.*;
import java.util.ArrayList;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<String[]> arrayList = new ArrayList<>();

        arrayList.add(br.readLine().split(" "));
        arrayList.add(br.readLine().split(" "));
        arrayList.add(br.readLine().split(" "));

        for (int i = 0; i < 3; i++) {
            int one = 0;
            for (int j = 0; j < 4; j++) {
                if (arrayList.get(i)[j].equals("1")) {
                    one++;
                }
            }
            if (one == 0) {
                bw.write("D\n");
            } else if (one == 1) {
                bw.write("C\n");
            } else if (one == 2) {
                bw.write("B\n");
            } else if (one == 3) {
                bw.write("A\n");
            } else {
                bw.write("E\n");
            }
        }


        bw.flush();
        br.close();
        bw.close();
    }
}
