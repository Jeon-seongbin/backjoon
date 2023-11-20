package com.leetcode.midium;

import java.util.HashSet;

public class FindUniqueBinaryString1980 {
    public static void main(String[] args) {
        findDifferentBinaryString(new String[]{"000","101"});
    }

    public static String findDifferentBinaryString(String[] nums) {


        HashSet<Integer> a = new HashSet<>();

        for (String num : nums) {
            a.add(Integer.parseInt(num, 2));
        }
        int n = nums.length;

        for (int i = 0; i <= n; i++) {
            if (!a.contains(i)) {
                String answer = Integer.toBinaryString(i);
                while (answer.length() < n) {
                    answer = "0" + answer;

                }
                return answer;
            }
        }
        return "";
    }
}
