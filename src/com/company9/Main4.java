package com.company9;

import java.io.*;
import java.util.ArrayList;

public class Main4 {
    public static void main(String[] args) throws IOException {
        Queue stack = new Queue();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int inputCount = Integer.parseInt(br.readLine());  // Read user input
        for (int i = 0; i < inputCount; i++) {
            String userInput = br.readLine();

            String[] userInput1 = userInput.split(" ");
            int userInput2 = 0;
            if (userInput1.length == 2) {
                userInput2 = Integer.parseInt(userInput1[1]);
            }

            switch (userInput1[0]) {
                case "push":
                    stack.push(userInput2);
                    break;
                case "pop":
                    bw.write(""+stack.pop()+"\n");
                    bw.flush();
                    break;
                case "size":
                    bw.write(""+stack.size()+"\n");
                    bw.flush();
                    break;
                case "empty":
                    bw.write(""+stack.isEmpty()+"\n");
                    bw.flush();
                    break;
                case "front":
                    bw.write(""+stack.front()+"\n");
                    bw.flush();
                    break;
                case "back":
                    bw.write(""+stack.back()+"\n");
                    bw.flush();
                    break;

            }
        }

        bw.flush();
        bw.close();
        br.close();

    }
}

class Queue {

    static private final ArrayList<Integer> data = new ArrayList<>();

    /*


  OK size: 큐에 들어있는 정수의 개수를 출력한다.
  OK empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
     */

    /**
     *   push X: 정수 X를 큐에 넣는 연산이다.
     */
    public void push(int i) {
        data.add(i);
    }

    /**
     *   pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
     */
    public int pop() {

        if (this.isEmpty() == 1) {
            return -1;
        }

        int result = this.front();
        data.remove(0);

        return result;
    }

    public int size() {
        return data.size();
    }

    public int isEmpty() {
        if (data.size() == 0) {
            return 1;
        }
        return 0;
    }

    public int back() {
        if (this.isEmpty() == 1) {
            return -1;
        }
        int index = data.size() - 1;
        return data.get(index);
    }

    public int front() {
        if (this.isEmpty() == 1) {
            return -1;
        }
        return data.get(0);
    }
}

