package com.leetcode.easy;

public class SumofAllSubsetXORTotals1863 {
    public static void main(String[] args) {

    }

    int result = 0;

    public int subsetXORSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            helper(nums, 0, i);
        }
        return result;
    }

    private void helper(int[] nums, int curr, int index) {
        if (index == nums.length) {
            return;
        }
        curr = nums[index] ^ curr;
        result += curr;
        for(int i = index + 1 ; i < nums.length; i++){
            helper(nums, curr, i);
        }
    }
}
