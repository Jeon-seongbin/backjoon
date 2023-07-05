package com.leetcode.midium;

public class LongestSubarrayOf1sAfterDeletingOneElement1493 {
    public static void main(String[] args) {
        longestSubarray(new int[]{1,1,0,1});
    }

    public static int longestSubarray(int[] nums) {
        int zero = 0;
        int left = 0;
        int answer = 0;
        int numsLength = nums.length;

        for (int i = 0; i < numsLength; i++) {
            if (nums[i] == 0) {
                zero++;
            }
            while (zero > 1) {
                if (nums[left] == 0) {
                    zero--;
                }
                left++;
            }
            answer = Math.max(answer, i - left);
        }

        return answer;
    }

}
