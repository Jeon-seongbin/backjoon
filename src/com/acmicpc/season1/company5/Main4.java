package com.acmicpc.season1.company5;

public class Main4 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i <= 1000000; i++) {
            int result = calculator(String.valueOf(i), 0);
            if (result == 5) {
                count++;
            }
        }
        System.out.println(count);
    }


    static public int calculator(String input, int count) {
        if (input.length() == 1) {
            return count;
        }
        // 분리
        char[] inputs = input.toCharArray();

        int temp = 1;
        // 계산
        for (char i : inputs) {
            temp *= Integer.parseInt(String.valueOf(i));
        }
        count++;

        // 1자리?
        if (10 <= temp) {
            // 아니면 분리
            count = calculator(String.valueOf(temp), count);
        }
        // 맞으면 갯수 리턴
        return count;
    }
}
