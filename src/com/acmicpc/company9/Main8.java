package com.acmicpc.company9;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
// https://www.acmicpc.net/problem/17219
public class Main8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] userInputs = br.readLine().split(" ");
        int sitePwCount = Integer.parseInt(userInputs[0]);
        int findPwCount = Integer.parseInt(userInputs[1]);

        HashMap<String, String> hashMap= new HashMap<>();
        ArrayList<String> resultPw = new ArrayList<>();

        for (int i = 0; i < sitePwCount; i++) {
            userInputs = br.readLine().split(" ");
            hashMap.put(userInputs[0], userInputs[1]);
        }

        for (int i = 0; i < findPwCount; i++) {
            String target = br.readLine();
            if (hashMap.containsKey(target)) {
                resultPw.add(hashMap.get(target));
            }
        }

        for (String s : resultPw) {
            bw.write(s + "\n");
        }

        br.close();
        bw.close();
        br.close();
    }
}
