package com.company8;

import java.io.*;
import java.util.ArrayList;

// https://www.acmicpc.net/problem/10773
public class Main3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        ArrayList<Integer> stack = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            int userInput = Integer.parseInt(br.readLine());

            if (userInput == 0) {
                stack.remove(stack.size() - 1);
            } else {
                stack.add(userInput);
            }
        }
        count = 0;
        for (int i = 0; i < stack.size(); i++) {
            count += stack.get(i);
        }
        bw.write("" + count);

        bw.flush();
        bw.close();
        br.close();
    }
}
