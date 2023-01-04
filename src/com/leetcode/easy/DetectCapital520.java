package com.leetcode.easy;

public class DetectCapital520 {
    public static void main(String[] args) {
        System.out.println(detectCapitalUse("FLaG"));
        System.out.println(detectCapitalUse("USA"));
        System.out.println(detectCapitalUse("Google"));
        System.out.println(detectCapitalUse("Leetcode"));
        System.out.println(detectCapitalUse("leetcode"));
    }

    public static boolean detectCapitalUse(String word) {

        boolean check = false;
        for (char a : word.toCharArray()) {
            if (65 <= a && a <= 90) {
                check = true;
            } else {
                check = false;
                break;
            }
        }
        if (check) {
            return true;
        }

        for (char a : word.toCharArray()) {
            if (97 <= a && a <= 122) {
                check = true;
            } else {
                check = false;
                break;
            }
        }

        if (check) {
            return true;
        }

        int index = 0;

        for (char a : word.toCharArray()) {
            if (index == 0 && 65 <= a && a <= 90) {
                check = true;
            } else {
                if (65 <= a && a <= 90) {
                    check = false;
                    break;
                }
            }
            index++;
        }

        return check;
    }
}
