package com.leetcode.easy;

import java.util.Stack;

public class ImplementQueueusingStacks232 {
    public static void main(String[] args) {

    }

    class MyQueue {

        Stack<Integer> mainStack;
        Stack<Integer> subStack;

        public MyQueue() {
            mainStack = new Stack<>();
            subStack = new Stack<>();
        }

        public void push(int x) {
            mainStack.push(x);
        }

        public int pop() {
            while(!mainStack.isEmpty()){
                subStack.add(mainStack.pop());
            }
            int result = subStack.pop();

            while(!subStack.isEmpty()){
                mainStack.add(subStack.pop());
            }

            return result;
        }

        public int peek() {
            while(!mainStack.isEmpty()){
                subStack.add(mainStack.pop());
            }
            int result = subStack.peek();

            while(!subStack.isEmpty()){
                mainStack.add(subStack.pop());
            }

            return result;
        }

        public boolean empty() {
            return mainStack.isEmpty();

        }
    }

}
