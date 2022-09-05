package com.leetcode.midium;

public class SortColors75 {
    public static void main(String[] args) {
        sortColors(new int[]{2, 0, 2, 1, 1, 0});
    }

    public static void sortColors(int[] nums) {
        int zero = 0;
        int one = 0;

        for (int num : nums) {
            if (num == 0) {
                zero++;
            } else if (num == 1) {
                one++;
            }
        }

        int[] result = new int[nums.length];

        for (int i = 0; i < zero; i++) {
            nums[i] = 0;
        }

        for (int i = zero; i < zero + one; i++) {
            nums[i] = 1;
        }

        for (int i = zero + one; i < nums.length; i++) {
            nums[i] = 2;
        }
    }
}
