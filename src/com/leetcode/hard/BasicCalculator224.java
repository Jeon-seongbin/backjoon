package com.leetcode.hard;

import java.util.Stack;

public class BasicCalculator224 {
    public static void main(String[] args) {
        System.out.println(calculate("2+(3)"));
    }

    public static int calculate(String s) {
        int sum = 0;

        // one: +
        // minus one: -
        int isSignPlus = 1;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                // プラスと数値を合わせて計算する

                // valを初期化
                int val = 0;

                //数値の場合、数値をvalに保存する
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    val = val * 10 + (s.charAt(i) - '0');
                    i++;
                }

                i--;
                val = val * isSignPlus;
                // プラス、マイナスの適応

                isSignPlus = 1;
                // 初期化

                sum += val;
                // 結果と合算する

            } else if (ch == '(') {
                //括弧が始めた場合は状況を保存
                stack.push(sum);
                stack.push(isSignPlus);

                // 初期化
                sum = 0;
                isSignPlus = 1;

            } else if (ch == ')') {
                //括弧が終わったら、今の状況と保存されている状況と合わせる
                sum *= stack.pop();
                sum += stack.pop();
            } else if (ch == '-') {

                // マイナスの場合、-1を掛け算する
                isSignPlus *= -1;
            }
        }

        return sum;

    }

}
