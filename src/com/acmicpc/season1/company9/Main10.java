package com.acmicpc.season1.company9;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

// https://www.acmicpc.net/problem/1620
public class Main10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] userInputs = br.readLine().split(" ");

        int pocketmonCount = Integer.parseInt(userInputs[0]);
        int question = Integer.parseInt(userInputs[1]);

        HashMap<String, Integer> hashMap = new HashMap<>();
        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i < pocketmonCount; i++) {
            String userInput = br.readLine();
            hashMap.put(userInput, i + 1);
            arrayList.add(userInput);
        }

        for (int i = 0; i < question; i++) {
            String userInput = br.readLine();
            try {
                int value = Integer.parseInt(userInput);
                bw.write(arrayList.get(value -1)+"\n");
            } catch (Exception e) {

                bw.write("" + hashMap.get(userInput)+"\n");

            }


        }

        bw.flush();
        br.close();
        bw.close();
    }
}
