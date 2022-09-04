package com.leetcode.midium;

import java.util.ArrayList;
import java.util.List;

public class Triangle120 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            arrayLists.add(new ArrayList<>());
        }
        // triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
        arrayLists.get(0).add(2);

        arrayLists.get(1).add(3);
        arrayLists.get(1).add(4);

        arrayLists.get(2).add(5);
        arrayLists.get(2).add(6);
        arrayLists.get(2).add(7);

        arrayLists.get(3).add(4);
        arrayLists.get(3).add(1);
        arrayLists.get(3).add(8);
        arrayLists.get(3).add(3);

        System.out.println(minimumTotal(arrayLists));
    }

    public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();

        for (int i = 0; i < triangle.size(); i++) {
            dp.add(new ArrayList<>());
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp.get(i).add(triangle.get(i).get(j));
            }

        }
        dp.add(new ArrayList<>());

        for (int i = 0; i < dp.size(); i++) {
            dp.get(dp.size() - 1).add(0);
        }

        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int now = triangle.get(i).get(j);
                int prev1 = dp.get(i + 1).get(j);
                int prev2 = dp.get(i + 1).get(j + 1);

                prev1 += now;
                prev2 += now;

                dp.get(i).set(j, Math.min(prev1, prev2));
            }
        }

        return dp.get(0).get(0);
    }
}
