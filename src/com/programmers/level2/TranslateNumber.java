package com.programmers.level2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class TranslateNumber {
    public static void main(String[] args) {

    }

    public int solution(int x, int y, int n) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();

        queue.add(x);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int peek = queue.peek();
                if (peek == y) {
                    return count;
                }
                int nowX = queue.poll();
                if (nowX + n <= y && !set.contains(nowX + n)) {
                    set.add(nowX + n);
                    queue.add(nowX + n);
                }
                if (nowX * 2 <= y && !set.contains(nowX * 2)) {
                    set.add(nowX * 2);
                    queue.add(nowX * 2);
                }
                if (nowX * 3 <= y && !set.contains(nowX * 3)) {
                    set.add(nowX * 3);
                    queue.add(nowX * 3);
                }
            }
            count++;
        }
        return -1;
    }

}
