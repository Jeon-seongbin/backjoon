package com.company7;

public class Main2 {
    public static void main(String[] args) {
        int[] nums = new int[5];
        nums[0] = 2;
        nums[1] = 3;
        nums[2] = 1;
        nums[3] = 1;
        nums[4] = 4;

        Main2 m = new Main2();
        m.canJump(nums);
    }

    public boolean canJump(int[] nums) {


        // ask whether nums could be null
        final int N = nums.length;
        if (N <= 1) return true;
        int max = 0;
        for (int i = 0; i < N - 1; i++) {
            if (max < i) return false;  // If the max reached position is less than i, return false.
            max = Math.max(max, i + nums[i]);
        }
        return max >= N - 1;

    }
}
