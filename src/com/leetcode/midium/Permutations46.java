package com.leetcode.midium;


import java.util.ArrayList;
import java.util.List;

public class Permutations46 {
    public static void main(String[] args) {
        permute(new int[]{1, 2, 3});
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(new ArrayList<>(), new boolean[nums.length], nums, result);
        return result;
    }

    public static void helper(ArrayList<Integer> arrayList, boolean[] isVisited, int[] nums, List<List<Integer>> result) {
        if (arrayList.size() == nums.length) {
            result.add(new ArrayList<>(arrayList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (isVisited[i]) {
                continue;
            }

            isVisited[i] = true;
            arrayList.add(nums[i]);
            helper(arrayList, isVisited, nums, result);

            isVisited[i] = false;

            // 여기서 제거를 해야 다음 숫자가 들어 올 수 있음
            arrayList.remove(arrayList.size() - 1);
        }
    }
}
