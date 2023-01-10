package com.leetcode.midium;

public class GasStation134 {
    public static void main(String[] args) {

    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        int costSum = 0;

        for (int g : gas) {
            gasSum += g;
        }

        for (int c : cost) {
            costSum += c;
        }
        if (gasSum < costSum) {
            return -1;
        }

        gasSum = 0;
        int startingPoint = 0;

        for (int i = 0; i < gas.length; i++) {
            gasSum = gasSum + (gas[i] - cost[i]);

            if (gasSum < 0) {
                gasSum = 0;
                startingPoint = i + 1;
            }
        }
        return startingPoint;

    }
}
