package com.acmicpc.company14;

import java.util.*;

public class Main4 {

    public static void main(String[] args) {
        int[] userInput = {0, 2, 3, 4, 5, 6, 8, 9, 12, 13, 15};

        List<String> result = summaryRanges(userInput);
        userInput[1]++;
    }

    static public List<String> summaryRanges(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return new ArrayList<>();
        }
        int start = nums[0];
        int end = 0;
        List<String> ranges = new ArrayList<>();
        for (int i = 1; i < len; i++) {
            if (nums[i - 1] + 1 != nums[i]) {
                end = nums[i - 1];
                if (start == end) {
                    ranges.add(String.valueOf(start));
                } else {
                    ranges.add(start + "->" + end);
                }
                start = nums[i];
            }
        }
        if (start == nums[len - 1]) {
            ranges.add(String.valueOf(start));
        } else {
            ranges.add(start + "->" + nums[len - 1]);
        }
        return ranges;
    }
}
