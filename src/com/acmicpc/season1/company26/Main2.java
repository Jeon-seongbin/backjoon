package com.acmicpc.season1.company26;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int userInput = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        ArrayList<String> arrayList = new ArrayList<>();
        int arr[] = new int[userInput + 1];
        for (int i = 1; i <= userInput; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int idx = 1;
        for (int i = 1; i <= userInput; i++) {
            arrayList.add("+");
            stack.push(i);

            while (!stack.isEmpty() && stack.peek() == arr[idx]) {
                stack.pop();
                arrayList.add("-");
                idx++;
            }
        }

        if (stack.isEmpty()) {
            for (String a : arrayList) {
                System.out.println(a);
            }
        } else {
            System.out.println("NO");
        }
    }
}
