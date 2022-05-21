package com.acmicpc.company26;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int userInput = Integer.parseInt(br.readLine());

        long result = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= userInput; i++) {
            int temp = Integer.parseInt(br.readLine());
            // 현재보다 낮은 것들
            while (!stack.isEmpty() && stack.peek() <= temp) {
                // 관찰 불가능 한 건물들은 버림
                stack.pop();
            }
            // 현재 건물은 버려진 건물들 빼고 관찰이 가능하다
            result += stack.size();
            stack.add(temp);
        }
        bw.write("" + result);
        bw.flush();
    }
}
