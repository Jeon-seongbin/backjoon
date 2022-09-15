package com.leetcode.midium;

public class ReverseInteger7 {
    public static void main(String[] args) {
        System.out.println(reverse(12340));
    }

    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            int nextStep = rev * 10;
            rev = nextStep + pop;
        }
        return rev;
    }
}
