package com.acmicpc.company26;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main3 {
    public static int userInput;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        userInput = Integer.parseInt(st.nextToken());

        // 탑의 높이, 탑의 번호
        Stack<int[]> stack = new Stack<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < userInput; i++) {
            int n = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty()) {
                if (stack.peek()[0] < n) {
                    stack.pop();
                } else {
                    System.out.print(stack.peek()[1] + " ");
                    break;
                }
            }

            if (stack.isEmpty()) {
                System.out.print("0 ");
            }
            stack.push(new int[]{n, i + 1});
        }
        br.close();

    }

}
