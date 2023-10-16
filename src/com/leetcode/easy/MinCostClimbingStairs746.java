package com.leetcode.easy;

public class MinCostClimbingStairs746 {
    public static void main(String[] args) {
        minCostClimbingStairs(new int[]{10, 15, 20});
    }


    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] tempCost = new int[cost.length];
        tempCost[0] = cost[0];
        tempCost[1] = cost[1];

        for (int i = 2; i < n; i++) {
            tempCost[i] = Math.min(cost[i] + tempCost[i - 1], cost[i] + tempCost[i - 2]);
        }

        return Math.min(tempCost[n - 1], tempCost[n - 2]);
    }

}
