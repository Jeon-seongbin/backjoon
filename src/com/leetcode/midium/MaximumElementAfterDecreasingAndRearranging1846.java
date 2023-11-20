package com.leetcode.midium;

import java.util.Arrays;
import java.util.HashSet;

public class MaximumElementAfterDecreasingAndRearranging1846 {
    public static void main(String[] args) {

    }

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) <= 1) {
                continue;
            } else {
                arr[i] = arr[i - 1] + 1;
            }
        }
        return arr[arr.length - 1];
    }

    public int maximumElementAfterDecrementingAndRearranging1(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int a : arr) {
            set.add(a);
        }
        return set.size();
    }
}
