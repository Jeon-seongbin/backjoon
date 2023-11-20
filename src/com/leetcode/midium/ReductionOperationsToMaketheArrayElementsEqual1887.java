package com.leetcode.midium;

public class ReductionOperationsToMaketheArrayElementsEqual1887 {
    public static void main(String[] args) {
        reductionOperations(new int[]{5, 1, 3});
    }

    public static int reductionOperations(int[] nums) {

        int max = 50_001;

        int[] frag = new int[max];

        for (int num : nums) {
            frag[num]++;
        }

        int operation = 0;
        int result = 0;

        for (int i = max - 1; i >= 0; i--) {
            if (0 < frag[i]) {
                operation += frag[i];
                result += operation - frag[i];
            }
        }

        return result;
    }
}
