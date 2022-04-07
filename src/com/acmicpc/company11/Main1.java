package com.acmicpc.company11;

import java.io.*;
import java.util.Arrays;

public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            String[] userInputs = br.readLine().split(" ");

            char[] userInputs1 = userInputs[0].toCharArray();

            char[] userInputs2 = userInputs[1].toCharArray();

            Arrays.sort(userInputs1);
            Arrays.sort(userInputs2);

            String userInputs11 = Arrays.toString(userInputs1);
            String userInputs22 = Arrays.toString(userInputs2);

            if (userInputs11.equals(userInputs22)) {
                bw.write(userInputs[0] + " & " + userInputs[1] + " are anagrams.\n");
            } else {
                bw.write(userInputs[0] + " & " + userInputs[1] + " are NOT anagrams.\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
