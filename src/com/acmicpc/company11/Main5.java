package com.acmicpc.company11;

import java.io.*;
import java.util.ArrayList;

public class Main5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        ArrayList<Integer> arrayList = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            int a = Integer.parseInt(br.readLine());
            arrayList.add(a);
            sum += a;
        }

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - arrayList.get(i) - arrayList.get(j) == 100) {
                    for(int k = 0; k < 9 ; k++){
                        if(k != i && k != j) {
                            bw.write("" + arrayList.get(k) + "\n");
                            bw.flush();
                        }

                    }
                    return;
                }

            }
        }


        bw.flush();
        bw.close();
        br.close();
    }

}