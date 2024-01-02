package com.leetcode.midium;

public class MinimumTimeToMakeRopeColorful1578 {
    public static void main(String[] args) {
        minCost("aabaa", new int[]{1, 2, 3, 4, 1});
    }

    public static int minCost(String colors, int[] neededTime) {

        int left = 0;
        int result = 0;

        char[] charArray = colors.toCharArray();

        for (int right = 1; right < neededTime.length; right++) {
            if (charArray[right] == charArray[left]) {

                if (neededTime[left] < neededTime[right]) {

                    result += neededTime[left];
                    left = right;
                } else {
                    result += neededTime[right];
                }

            } else {
                left = right;
            }
        }

        return result;
    }
}
