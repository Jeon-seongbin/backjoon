package com.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromSortedArray26 {
    public static void main(String[] args) {
        removeDuplicates(new int[]{1, 1, 2});
    }

    public static int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            set.add(i);

        }
        Integer[] array = set.stream().toArray(Integer[]::new);

        Arrays.sort(array);
        for (int i = 0; i < nums.length; i++) {
            if (i < array.length) {
                nums[i] = array[i];
            }
        }
        return set.size();
    }
}
