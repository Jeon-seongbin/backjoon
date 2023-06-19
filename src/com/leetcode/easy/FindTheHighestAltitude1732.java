package com.leetcode.easy;

public class FindTheHighestAltitude1732 {
    public static void main(String[] args) {
        largestAltitude(new int[]{-4, -3, -2, -1, 4, 3, 2});
    }

    public static int largestAltitude(int[] gain) {


        int[] dp = new int[gain.length + 1];
        int index = 0;
        dp[index] = 0;

        index++;
        int result = 0;

        for (int i : gain) {
            dp[index] = dp[index - 1] + i;
            result = Math.max(result, dp[index]);
            index++;
        }

        return result;
    }
}
