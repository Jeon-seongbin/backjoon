package com.programmers.level2;

import java.util.Stack;

public class HaitatuBox {
    public static void main(String[] args) {
        solution(new int[]{4, 3, 1, 2, 5});
//        solution(new int[]{5, 4, 3, 2, 1});
    }

    public static int solution(int[] order) {
        int answer = 0;
        int orderSize = order.length;
        Stack<Integer> subBelt = new Stack<>();

        int index = 0;

        for (int box = 1; box <= orderSize; box++) {
            int wantBox = order[index];
            if (wantBox != box) {
                subBelt.add(box);
                continue;
            }
            index++;
            answer++;

            while (subBelt.size() != 0 && order[index] == subBelt.peek()) {
                subBelt.pop();
                index++;
                answer++;
            }
        }

        return answer;
    }
}
