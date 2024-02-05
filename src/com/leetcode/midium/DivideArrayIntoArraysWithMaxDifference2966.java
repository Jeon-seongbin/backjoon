package com.leetcode.midium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DivideArrayIntoArraysWithMaxDifference2966 {
    public static void main(String[] args) {
        divideArray(new int[]{1, 3, 4, 8, 7, 9, 3, 5, 1}, 2);
    }

    public static int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);

        int[][] result = new int[nums.length / 3][3];
        for (int i = 0; i < nums.length; i += 3) {
            if (k < nums[i + 2] - nums[i]) {
                return new int[0][0];
            }

            result[i / 3] = new int[]{nums[i], nums[i + 1], nums[i + 2]};


        }
        return result;


//        for (int i = 0; i < nums.length; i++) {
//            if (i % 3 == 0) {
//                start++;
//            }
//            int now = 0;
//            for (int j = start; j < start + 3; j++) {
//
//                if (j != 0) {
//                    if (nums[j - 1] - pq.peek() < k) {
//                        result = new int[0][0];
//                        return result;
//                    }
//                }
//                pq.add(nums[j]);
//            }
//        }

//        return null;
    }
}
