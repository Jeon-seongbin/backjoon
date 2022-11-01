package com.codewars.fiveKyu;

public class Max {
    public static void main(String[] args) {

    }

    public static int sequence(int[] arr) {
        int result = 0;
        int max = 0;

        for (int j : arr) {
            result = Math.max(result + j, 0);
            max = Math.max(result, max);
        }
        return max;
    }
}
