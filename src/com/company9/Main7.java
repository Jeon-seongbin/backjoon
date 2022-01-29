package com.company9;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
// https://www.acmicpc.net/problem/1764
public class Main7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] userInputs = br.readLine().split(" ");
        int noHearCount = Integer.parseInt(userInputs[0]);
        int noSeeCount = Integer.parseInt(userInputs[1]);

        HashSet<String> noHear = new HashSet<>();
        ArrayList<String> dutBoJap = new ArrayList<>();

        for (int i = 0; i < noHearCount; i++) {
            noHear.add(br.readLine());
        }

        for (int i = 0; i < noSeeCount; i++) {
            String target = br.readLine();
            if (noHear.contains(target)) {
                dutBoJap.add(target);
            }
        }

        bw.write("" + dutBoJap.size() + "\n");

        Collections.sort(dutBoJap);

        for (String s : dutBoJap) {
            bw.write(s + "\n");
        }

        br.close();
        bw.close();
        br.close();
    }
}
