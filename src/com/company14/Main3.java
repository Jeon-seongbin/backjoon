package com.company14;

import java.io.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Deque<Pair> deque = new ArrayDeque<>();

        for (int i = 1; i <= count; i++) {
            int userInput = Integer.parseInt(st.nextToken());
            deque.add(new Pair(userInput, i));
        }

        while (!deque.isEmpty()) {
            sb.append(deque.getFirst().count + " ");
            int next = deque.pollFirst().userInput;
            if (deque.isEmpty()) break;
            if (next > 0) {

                for (int i = 0; i < next - 1; i++) {
                    deque.addLast(deque.pollFirst());
                }
            } else {
                for (int i = 0; i < Math.abs(next); i++) {
                    deque.addFirst(deque.pollLast());
                }
            }
        }

        System.out.println(sb.toString());
        br.close();
    }
}

class Pair {
    int userInput;
    int count;


    Pair(int userInput, int count) {
        this.userInput = userInput;
        this.count = count;
    }
}