package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;

public class SortArrayByParity905 {
    public static void main(String[] args) {
        sortArrayByParity(new int[]{1, 2,1,1,3,4});
    }

    public int[] sortArrayByParity1(int[] nums) {

        Arrays.sort(nums);

        ArrayList<Integer> odds = new ArrayList<>();
        ArrayList<Integer> nonOdds = new ArrayList<>();

        for (int num : nums) {
            if (num % 2 == 0) {
                odds.add(num);
            } else {
                nonOdds.add(num);
            }
        }

        int[] temp = new int[nums.length];
        int i = 0;

        for (; i < odds.size(); i++) {
            temp[i] = odds.get(i);
        }

        for (int j = 0; j < nonOdds.size(); j++) {
            temp[i] = nonOdds.get(j);
            i++;
        }

        return temp;
    }

    public static int[] sortArrayByParity(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                j++;
            }
        }
        return nums;
    }
}
