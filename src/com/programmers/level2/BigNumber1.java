package com.programmers.level2;

import java.util.Stack;

public class BigNumber1 {
    public static void main(String[] args) {
    }

    public static int[] solution(int[] numbers) {

        int[] result = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            result[i] = -1;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < numbers.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            }

            while (!stack.empty() && numbers[stack.peek()] < numbers[i]) {
                result[stack.peek()] = numbers[i];
                stack.pop();
            }

            stack.push(i);
        }
        return result;
    }
}
