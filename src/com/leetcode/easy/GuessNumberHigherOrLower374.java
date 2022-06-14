package com.leetcode.easy;

public class GuessNumberHigherOrLower374 {
    public static void main(String[] args) {

    }

    public static int guessNumber(int n) {

        int start = 0;
        int end = n;

        while (start <= end) {
            int pivot = start + (end - start) / 2;
//            int guess = guess(pivot);
            int guess = 0;
            if (guess == 0) {
                return pivot;
            } else if (guess == 1) {
                // 1: Your guess is lower than the number I picked (i.e. num < pick).
                end = pivot - 1;
            } else {
                start = pivot + 1;
            }

        }
        return -1;
    }
}
