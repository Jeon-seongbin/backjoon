package com.acmicpc.company12;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] userInputs = br.readLine().split(" ");
        int human = Integer.parseInt(userInputs[0]);
        int delete = Integer.parseInt(userInputs[1]);

        Queue<Integer> queue = new LinkedList<>();

        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 1; i <= human; i++) {
            queue.add(i);
        }

        int count = 1;
        String arg = "<";
        while (!queue.isEmpty()) {
            for(int i = 0 ; i < delete - 1; i++){
                int val = queue.poll();
                queue.offer(val);
            }
            arg += (queue.poll() + ", ");
        }

        arg = arg.substring(0, arg.length() - 2);
        arg += ">";
        bw.write(arg);
        bw.flush();
        bw.close();
        br.close();
    }
}
