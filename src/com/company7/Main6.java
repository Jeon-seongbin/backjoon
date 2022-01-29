package com.company7;

import java.io.*;
import java.util.ArrayList;

public class Main6 {
    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String userInput;

        ArrayList<String> userInputs = new ArrayList<>();
        do {
            userInput = br.readLine();
            userInputs.add(userInput);
        } while (!userInput.equals("."));

        for (int i = 0; i < userInputs.size() - 1; i++) {
            userInput = userInputs.get(i);

            Stack stack = new Stack();

            for (int j = 0; j < userInput.length(); j++) {
                char u = userInput.charAt(j);
                if (u == '[') {
                    stack.putStack("[");
                } else if (u == ']') {
                    if (stack.getStack().equals("[")) {
                        stack.popStack();
                    } else {
                        stack.putStack(".");
                    }

                } else if (u == '{') {
                    stack.putStack("{");
                } else if (u == '}') {
                    if (stack.getStack().equals("{")) {
                        stack.popStack();
                    } else {
                        stack.putStack(".");
                    }

                } else if (u == '(') {
                    stack.putStack("(");
                } else if (u == ')') {
                    if (stack.getStack().equals("(")) {
                        stack.popStack();
                    } else {
                        stack.putStack(".");
                    }

                }

            }

            if (stack.isEmpty()) {
                bw.write("yes");
            } else {
                bw.write("no");
            }
            if (i <= userInputs.size() - 1) {
                bw.write("\n");
            }


        }

        bw.flush();
        bw.close();
        br.close();

    }
}

class Stack {
    Stack() {
        stack = new ArrayList<>();
        stackSize = 0;
    }

    private ArrayList<String> stack;
    private int stackSize;

    public boolean putStack(String str) {
        this.stack.add(str);
        this.stackSize++;
        return true;
    }

    public String getStack() {
        if (stackSize == 0) {
            return "-1";
        }
        return stack.get(stackSize - 1);
    }

    public String popStack() {
        if (stackSize == 0) {
            return "-1";
        }
        String result = stack.get(stackSize - 1);

        stack.remove(stackSize - 1);
        stackSize--;
        return result;
    }

    public boolean isEmpty() {
        return 1 > stackSize;
    }

}