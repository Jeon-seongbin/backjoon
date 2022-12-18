package com.leetcode.midium;

import java.util.Stack;

public class DailyTemperatures739 {
    public static void main(String[] args) {
        int[] count = dailyTemperatures(new int[]{99, 99, 99, 99, 100});
        for (int i = 0; i < count.length; i++) {
            System.out.println(count[i]);
        }
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] count = new int[length];
        Stack<Integer> stack = new Stack<>();
        for (int now = 0; now < length; now++) {
            while (!stack.empty() && temperatures[now] > temperatures[stack.peek()]) {
                int pastIndex = stack.pop();
                int different = now - pastIndex;
                count[pastIndex] = different;
            }
            stack.add(now);
        }
        return count;
    }

    public static int[] dailyTemperatures_TLE(int[] temperatures) {
        int length = temperatures.length;
        int[] count = new int[length];
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (temperatures[i] < temperatures[j]) {
                    count[i] = j - i;
                    break;
                }
            }
        }
        return count;
    }
}
