package com.leetcode.midium;

public class MaximumSwap670 {
    public static void main(String[] args) {

    }

    public int maximumSwap(int num) {

        String numStr = Integer.toString(num); // Convert num to string for easy manipulation
        int n = numStr.length();
        int maxNum = num; // Track the maximum number found

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                char[] temp = numStr.toCharArray();

                char t = temp[i];
                temp[i] = temp[j];
                temp[j] = t;
                int tempNum = Integer.parseInt(new String(temp));

                maxNum = Math.max(maxNum, tempNum);
            }
        }

        return maxNum;
    }
}
