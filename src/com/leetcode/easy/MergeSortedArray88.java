package com.leetcode.easy;

import java.util.Arrays;

public class MergeSortedArray88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (nums1.length != (m + n)) return;
        int[] result = new int[m + n];
        int i = 0;
        for (; i < m; i++) {
            nums1[i] = nums1[i];
        }

        for (int j = 0; j < n; j++) {
            nums1[i] = nums2[j];
            i++;
        }
        Arrays.sort(nums1);

    }
}
