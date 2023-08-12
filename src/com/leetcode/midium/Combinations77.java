package com.leetcode.midium;

import java.util.ArrayList;
import java.util.List;

public class Combinations77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        helper(1, result, new ArrayList<>(), n, k);
        return result;
    }

    public void helper(int startIndex, List<List<Integer>> result, List<Integer> combination, int n, int k) {
        if (combination.size() == k) {
            result.add(new ArrayList<>(a));
            return;
        }

        for (int i = startIndex; i <= n; i++) {
            combination.add(i);
            helper(i + 1, result, combination, n, k);
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
    }
}
