package com.leetcode.midium;

import java.util.*;

public class ConvertAnArrayIntoA2DArrayWithConditions2610 {
    public static void main(String[] args) {
        findMatrix(new int[]{1, 3, 4, 1, 2, 3, 1});
    }

    public static List<List<Integer>> findMatrix(int[] nums) {
        HashMap<Integer, Boolean> indexHashmap = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            indexHashmap.put(i, false);
        }

        while (true) {

            HashSet<Integer> a = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (indexHashmap.get(i) == true) {
                    continue;
                }
                if(a.contains(nums[i])){
                    continue;
                }

                a.add(nums[i]);
                indexHashmap.put(i, true);
            }


            ArrayList<Integer> temp = new ArrayList<>(a);

            result.add(temp);


            if (indexHashmap.values().stream().filter(obj -> obj.booleanValue() == true).count() == nums.length) {
                break;
            }


        }
        return result;
    }
}
