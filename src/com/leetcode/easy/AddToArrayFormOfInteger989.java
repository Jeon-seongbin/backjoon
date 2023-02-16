package com.leetcode.easy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddToArrayFormOfInteger989 {
    public static void main(String[] args) {
        List<Integer> result = addToArrayForm1(new int[]{1, 2, 0, 0}, 34);
        for (int a : result) {
            System.out.println(a);
        }
    }

    public static List<Integer> addToArrayForm1(int[] num, int k) {

        StringBuilder sb = new StringBuilder();
        for (int n : num) {
            sb.append(n);
        }
        System.out.println(sb);
        BigDecimal tempBigDecimal = new BigDecimal(sb.toString());

        BigDecimal tempK = new BigDecimal(k);


        tempBigDecimal = tempBigDecimal.add(tempK);
        List<Integer> result = new ArrayList<>();

        for (char c : tempBigDecimal.toString().toCharArray()) {
            result.add(Integer.parseInt("" + c));
        }
        return result;
    }

    public List<Integer> addToArrayForm(int[] num, int k) {

        List<Integer> result = new ArrayList<>();

        int i = num.length - 1;

        int value = 0;
        int digitSum = 0;
        int carry = 0;

        while (i >= 0 || k >= 0 || carry > 0) {
            digitSum = carry;
            if (i >= 0) {
                digitSum += num[i--];
            }
            if (k > 0) {
                digitSum += k % 10;
            }
            result.add(digitSum % 10);
            k /= 10;
            carry = digitSum / 10;
        }

        Collections.reverse(result);


        return result;
    }
}
