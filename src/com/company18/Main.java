package com.company18;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11399
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int userInput = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < userInput; i++) {
            arrayList.add(Integer.parseInt(st.nextToken()));
        }


        Collections.sort(arrayList);
        int sum = 0;
        for (int i = 0; i < userInput; i++) {
            for (int j = 0; j <= i; j++) {
                sum += arrayList.get(j);
            }
        }
        bw.write("" + sum);


        br.close();
        bw.close();
    }
}
