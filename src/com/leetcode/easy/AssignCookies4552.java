package com.leetcode.easy;

import java.util.Arrays;

public class AssignCookies4552 {
    public static void main(String[] args) {

    }
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int size = Math.min(g.length, s.length);

        int result = 0;

        for(int i = 0 ; i < size; i++){

            if(g[i] <= s[i]){
                result++;
            }
        }

        return result;
    }
}
