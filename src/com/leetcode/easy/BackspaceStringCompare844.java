package com.leetcode.easy;

import java.util.ArrayList;

public class BackspaceStringCompare844 {
    public static void main(String[] args) {
        backspaceCompare("abc#", "ab");

    }

    public static boolean backspaceCompare(String s, String t) {


        String tempS = "";
        String tempT = "";

        for (char ss : s.toCharArray()) {
            if (ss == '#') {
                if (tempS.length() != 0) {
                    tempS = tempS.substring(0, tempS.length() - 1);
                }
            } else {
                tempS += "" + ss;
            }
        }

        for (char tt : t.toCharArray()) {
            if (tt == '#') {
                if (tempT.length() != 0) {
                    tempT = tempT.substring(0, tempT.length() - 1);
                }
            } else {
                tempT += "" + tt;
            }
        }

        return tempT.equals(tempS);
    }
}
