package com.leetcode.midium;

import java.util.*;

public class OnlineStockSpan901 {
    public static void main(String[] args) {

        StockSpanner sp = new StockSpanner();
//[[], [100], [80], [60], [70], [60], [75], [85]]
        System.out.println(sp.next(100));
        System.out.println("--");

        System.out.println(sp.next(80));
        System.out.println("--");
        System.out.println(sp.next(60));
        System.out.println("--");
        System.out.println(sp.next(70));
        System.out.println("--");
        System.out.println(sp.next(60));
        System.out.println("--");
        System.out.println(sp.next(75));
        System.out.println("--");
        System.out.println(sp.next(85));
    }

}

class StockSpanner {
    Stack<int[]> stack;
    // price , result

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int result = 1;
        while (!stack.empty() && stack.peek()[0] <= price) {
            result += stack.pop()[1];
        }
        stack.add(new int[]{price, result});
        return result;
    }
}
