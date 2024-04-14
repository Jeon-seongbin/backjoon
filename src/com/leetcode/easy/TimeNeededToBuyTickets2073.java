package com.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class TimeNeededToBuyTickets2073 {
    public static void main(String[] args) {


    }

    public int timeRequiredToBuy(int[] tickets, int k) {
        int result = 0;
        Queue<Integer> queue = new LinkedList<>();


        for (int i = 0; i < tickets.length; i++) {
            queue.add(i);
        }


        while (!queue.isEmpty()) {
            result++;
            int front = queue.poll();
            tickets[front]--;

            if (k == front && tickets[front] == 0) {
                return result;
            }
            if (tickets[front] != 0) {
                queue.add(front);
            }
        }


        return result;

    }
}
