package com.acmicpc.season1.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main4 {
    public static void main(String[] args) throws IOException {
        Deque deque = new Deque();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputCount = Integer.parseInt(br.readLine());  // Read user input
        for (int i = 0; i < inputCount; i++) {
            String userInput = br.readLine();

            String[] userInput1 = userInput.split(" ");
            int userInput2 = 0;
            if (userInput1.length == 2) {
                userInput2 = Integer.parseInt(userInput1[1]);
            }

            switch (userInput1[0]) {
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    System.out.println(deque.isEmpty());
                    break;
                case "push_front":
                  deque.push_front(userInput2);
                    break;
                case "push_back":
                    deque.push_back(userInput2);

                    break;
                case "pop_front":
                    deque.pop_front();

                    break;
                case "pop_back":
                    deque.pop_back();

                    break;
                case "front":
                    deque.front();

                    break;
                case "back":
                    deque.back();
                    break;


            }
        }
    }
}

class Deque {
    private static ArrayList<Integer> data = new ArrayList<>();

    //    size: 덱에 들어있는 정수의 개수를 출력한다.
    public int size() {
        return data.size();
    }

    // empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
    public int isEmpty() {
        if (data.size() == 0) {
            return 1;
        }
        return 0;
    }

    // push_back X: 정수 X를 덱의 뒤에 넣는다.
    public void push_back(int input) {
        data.add(input);
    }

    // push_front X: 정수 X를 덱의 앞에 넣는다.
    public void push_front(int input) {
        data.add(0, input);
    }



    // pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    public void pop_front() {
        if (this.isEmpty() == 1) {
            System.out.println("-1");
            return;
        }
        System.out.println(data.get(0));
        data.remove(0);
    }

    // pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    public void pop_back() {
        if (this.isEmpty() == 1) {
            System.out.println("-1");
            return;
        }
        int index = this.size() - 1;
        System.out.println(data.get(index));
        data.remove(index);
    }

    //front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    public void front() {
        if (this.isEmpty() == 1) {
            System.out.println("-1");
            return;
        }
        System.out.println(data.get(0));
    }

    // back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    public void back() {
        if (this.isEmpty() == 1) {
            System.out.println("-1");
            return;
        }
        int index = this.size() - 1;
        System.out.println(data.get(index));
    }
}