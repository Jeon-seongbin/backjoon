package com.paiza.c_class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class binary_search__basic_step0 {
    public static int N, M;
    public static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        Arrays.sort(nums);

        for (int i = 0; i < M; i++) {
            int a = Integer.parseInt(br.readLine());
            System.out.println(binarySearch(nums, a));
        }
    }

    public static String binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int pivot = left + (right - left) / 2;

            if (target == nums[pivot]) {
                return "Yes";
            }
            if (target < nums[pivot]) {
                right = pivot  - 1;
            } else {
                left = pivot + 1;
            }
        }

        return "No";
    }
}
