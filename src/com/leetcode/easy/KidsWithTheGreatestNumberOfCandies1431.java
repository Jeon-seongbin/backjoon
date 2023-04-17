package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies1431 {
    public static void main(String[] args) {

    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE;
        for (int c : candies) {
            max = Math.max(max, c);
        }

        ArrayList<Boolean> arrayList = new ArrayList<>();


        for (int c : candies) {
            if (c + extraCandies < max) {
                arrayList.add(false);
                continue;
            }
            arrayList.add(true);

        }
        return arrayList;
    }
}
