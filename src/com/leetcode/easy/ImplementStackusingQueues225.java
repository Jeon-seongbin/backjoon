package com.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackusingQueues225 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();

        myStack.push(1);
        myStack.push(2);

        myStack.push(3);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());

    }

    static class MyStack {

        Queue<Integer> queue;
        public MyStack() {
            queue = new LinkedList<>();

        }

        public void push(int x) {
            queue.add(x);
            for(int i = 0; i < queue.size() - 1; i++){
                queue.add(queue.poll());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

}