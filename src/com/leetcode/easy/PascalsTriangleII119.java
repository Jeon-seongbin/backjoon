package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII119 {
    public static void main(String[] args) {
        generate(3);
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= rowIndex; i++) {
            result.add(1);
            for (int j = i - 1; j > 0; j--) {
                result.set(j, result.get(j) + result.get(j - 1));
            }
        }

        return result;
    }

    public static List<Integer> generate(int rowIndex) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for (int i = 0; i < 33; i++) {
            result.add(new ArrayList<>());
        }
        result.get(0).add(1);

        if (rowIndex == 0) {
            return result.get(0);
        }
        result.get(1).add(1);
        result.get(1).add(1);

        if (rowIndex == 1) {
            return result.get(1);
        }

        result.get(2).add(1);
        result.get(2).add(2);
        result.get(2).add(1);

        if (rowIndex == 2) {
            return result.get(2);
        }


        for (int i = 3; i < 33; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    result.get(i).add(1);
                } else {
                    int a = result.get(i - 1).get(j) + result.get(i - 1).get(j - 1);
                    result.get(i).add(a);
                }
            }
        }

        return result.get(rowIndex);

    }
}
