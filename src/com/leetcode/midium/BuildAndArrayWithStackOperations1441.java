package com.leetcode.midium;

import java.util.ArrayList;
import java.util.List;

public class BuildAndArrayWithStackOperations1441 {
    public static void main(String[] args) {

    }

    public List<String> buildArray(int[] target, int n) {

        ArrayList<String> result = new ArrayList<>();

        int index = 0;
        int currNum = 1;

        while (currNum <= n && index < target.length) {

            int num = target[index];

            if (num == currNum) {

                result.add("Push");
                index++;
                currNum++;
            } else {
                result.add("Push");
                result.add("Pop");
                currNum++;
            }

        }

        return result;
    }
}
