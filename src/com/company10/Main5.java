package com.company10;

import java.io.*;
import java.util.ArrayList;

// https://www.acmicpc.net/problem/12605
public class Main5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        ArrayList<String[]> arrayList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String[] userInputs = br.readLine().split(" ");
            arrayList.add(userInputs);
        }

        for (int i = 0; i < count; i++) {
            bw.write("Case #" + (i + 1) + ": ");
            for (int j = arrayList.get(i).length - 1; j >= 0; j--) {
                bw.write(arrayList.get(i)[j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        br.close();
        bw.close();

    }
}
