package com.programmers.level2;

import java.util.PriorityQueue;

public class DefenceGame {
    public static void main(String[] args) {
        int result = solution(7, 3, new int[]{4, 2, 4, 5, 3, 3, 1});
        System.out.println(result);
    }

    public static int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < enemy.length; i++) {
            queue.add(enemy[i]);
            if (k < queue.size()) {
                n -= queue.poll();
            }
            if (n < 0) {
                return i;
            }
        }
        return enemy.length;
    }
}
