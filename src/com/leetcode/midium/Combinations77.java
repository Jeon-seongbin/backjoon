package com.leetcode.midium;

import java.util.ArrayList;
import java.util.List;

public class Combinations77 {
    public static void main(String[] args) {
        combine(4, 2);
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        helper(1, result, new ArrayList<>(), n, k);
        return result;
    }

    public static void helper(int start, List<List<Integer>> result, List<Integer> combine, int n, int k) {
        if (combine.size() == k) {
            result.add(new ArrayList<>(combine));
            return;
        }

        for (int i = start; i <= n; i++) {
            combine.add(i);
            helper(i + 1, result, combine, n, k);
            combine.remove(combine.size() - 1);
        }
    }
}
