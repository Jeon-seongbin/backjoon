package com.leetcode.midium;

public class FindTriangularSumOfAnArray2221 {
    public static void main(String[] args) {
        triangularSum(new int[]{1, 2, 3, 4, 5});
    }

    public static int triangularSum(int[] nums) {
        int n = nums.length;
        while (--n > 0) {
            for (int i = 0; i < n; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
        }
        return nums[0];
    }

    public static int triangularSum1(int[] nums) {


        for (int k = 1; k < nums.length; k++) {
            int[] temp = new int[nums.length];

            for (int i = 1; i <= nums.length; i++) {
                for (int j = i - 1; j > 0; j--) {
                    temp[j] = (nums[j] + nums[j - 1]) % 10;
                }
            }
            nums = temp;

        }

        return nums[nums.length - 1];
    }
}
