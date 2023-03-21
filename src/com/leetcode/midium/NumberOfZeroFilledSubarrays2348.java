package com.leetcode.midium;

public class NumberOfZeroFilledSubarrays2348 {
    public static void main(String[] args) {
        zeroFilledSubarray1(new int[]{0, 0, 0, 0, 0});
    }

    public static long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int count = 0;
        for (int num : nums) {
            if (num == 0) {
                count++;
                ans += count;
            } else {
                count = 0;
            }
        }
        return ans;
    }

    public static long zeroFilledSubarray1(int[] nums) {

        int count = 0;
        for (int i = 1; i <= nums.length; i++) {
            count = slidingWindowHelper(nums, i, count);
        }

        return count;
    }

    public static int slidingWindowHelper(int[] nums, int index, int count) {

        int length = nums.length;

        for (int i = 0; i <= length - index; i++) {
            boolean isCount = false;
            for (int j = i; j < i + index; j++) {
                if (nums[j] == 0) {
                    isCount = true;
                } else {
                    isCount = false;
                    break;
                }
            }
            if (isCount) {
                count++;
            }
        }
        return count;
    }
}
