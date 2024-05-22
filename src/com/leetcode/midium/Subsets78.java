package com.leetcode.midium;

import java.util.ArrayList;
import java.util.List;

public class Subsets78 {
    public static void main(String[] args) {
        subsets(new int[]{1, 2, 3});
    }

    static public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), nums, 0);
        return result;

    }

    public static void helper(List<List<Integer>> result, List<Integer> path, int[] nums, int index) {
        result.add(new ArrayList<>(path));
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            helper(result, path, nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

}
