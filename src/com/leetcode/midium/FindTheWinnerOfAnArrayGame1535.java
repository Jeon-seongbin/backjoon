package com.leetcode.midium;

public class FindTheWinnerOfAnArrayGame1535 {
    public static void main(String[] args) {
        getWinner(new int[]{3, 2, 1}, 10);
    }


    public static int getWinner(int[] arr, int k) {
        int max = arr[0];
        int curr = arr[0];
        int winStrict = 0;
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        for (int i = 1; i < arr.length; i++) {
            int opponent = arr[i];
            if (curr > opponent) {
                winStrict++;
            } else {
                curr = opponent;
                winStrict = 1;
            }

            if (winStrict == k || curr == max) {
                return curr;
            }
        }

        return -1;
    }
}
