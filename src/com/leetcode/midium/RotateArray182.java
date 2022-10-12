package com.leetcode.midium;

import java.util.Deque;
import java.util.LinkedList;

public class RotateArray182 {
    public static void main(String[] args) {

    }

    public void rotate(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            deque.add(nums[i]);
        }

        for (int i = 0; i < k; i++) {
            int x = deque.removeLast();
            deque.addFirst(x);
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = deque.removeFirst();
        }
    }
}
