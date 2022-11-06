package com.hackerRank.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MarcsCakewalk {
    public static void main(String[] args) {
        List<Integer> calorie = new ArrayList<>();
        calorie.add(1);
        calorie.add(3);
        calorie.add(2);

        marcsCakewalk(calorie);
    }

    public static long marcsCakewalk(List<Integer> calorie) {
        Collections.sort(calorie);
        long sum = 0;
        int multiplyCount = 0;
        for (int i = calorie.size() - 1; i >= 0; i--) {
            int get = calorie.get(i);
            sum += Math.pow(2, multiplyCount) * get;
            multiplyCount++;
        }
        return sum;
    }

}
