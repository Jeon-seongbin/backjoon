package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle118 {
    public static void main(String[] args) {
        generate(5);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();


        if(numRows == 0){
            return result;
        }

        for (int i = 0; i < numRows; i++) {
            result.add(new ArrayList<>());
        }

        result.get(0).add(1);
        if(numRows == 1){
            return result;
        }

        result.get(1).add(1);
        result.get(1).add(1);
        if(numRows == 2){
            return result;
        }

        result.get(2).add(1);
        result.get(2).add(2);
        result.get(2).add(1);

        if(numRows == 3){
            return result;
        }

        for (int i = 3; i < numRows; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    result.get(i).add(1);
                } else {
                    int a = result.get(i - 1).get(j) + result.get(i - 1).get(j - 1);
                    result.get(i).add(a);
                }
            }
        }

        return result;

    }
}
