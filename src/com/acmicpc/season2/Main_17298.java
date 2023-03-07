package com.acmicpc.season2;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int userInput = Integer.parseInt(br.readLine());

        int[] inputs = new int[userInput];
        int[] result = new int[userInput];

        Arrays.fill(result, -1);

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < userInput; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();

        stack.add(0);

        for (int i = 1; i < userInput; i++) {

            if (stack.isEmpty()) {
                stack.push(i);
            }

            while (!stack.isEmpty() && inputs[stack.peek()] < inputs[i]) {
                result[stack.peek()] = inputs[i];
                stack.pop();
            }
            stack.push(i);
        }

        for (int i = 0; i < userInput; i++) {
            bw.write("" + result[i] + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
