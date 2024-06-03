package com.leetcode.easy;

import java.util.Arrays;

public class SpecialArrayWithXElementsGreaterThanorEqualX1608 {
    public static void main(String[] args) {
        specialArray(new int[]{0, 0});
    }

    public static int specialArray(int[] nums) {
        Arrays.sort(nums);

        int min = 0;
        int max = 1000;

        while (min <= max) {
            int mid = (min + max) / 2;
            int a = checkNums(nums, mid);
            if (mid == a) {
                return mid;
            } else if (a < mid) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return -1;
    }

    public static int checkNums(int[] nums, int mid) {
        return (int) Arrays.stream(nums).filter(obj -> mid < obj).count();
    }


}
