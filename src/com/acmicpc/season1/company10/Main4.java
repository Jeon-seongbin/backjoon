package com.acmicpc.season1.company10;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
           arrayList.add(Integer.parseInt(br.readLine()  ));
        }

        Collections.sort(arrayList);


        for (int i = 0; i < 7; i++) {
            bw.write(""+ arrayList.get(i) + "\n");
        }


        bw.flush();
        br.close();
        bw.close();
    }
}
