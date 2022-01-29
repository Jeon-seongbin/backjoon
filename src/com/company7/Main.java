package com.company7;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/find-the-duplicate-number/
public class Main {

    public static void main(String[] args) {
        int[] nums = new int[5];
        nums[0] = 3;
        nums[1] = 1;
        nums[2] = 3;
        nums[3] = 4;
        nums[4] = 2;

        Main m = new Main();
        m.findDuplicate(nums);

    }

    public int findDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<Integer>();
        for (int num : nums) {
            if (seen.contains(num))
                return num;
            seen.add(num);
        }
        return -1;
    }
}
