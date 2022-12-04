package com.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;

public class AssignCookies455 {
    public static void main(String[] args) {

    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int childrenWant = 0;
        int cookieSize = 0;
        int result = 0;

        for (; childrenWant < g.length && cookieSize < s.length; ) {
            if (g[childrenWant] <= s[cookieSize]) {
                childrenWant++;
                cookieSize++;
                result++;
            } else {
                cookieSize++;
            }
        }
        return result;
    }

    public static int findContentChildren1(int[] g, int[] s) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int gg : g) {
            hashMap.put(gg, hashMap.getOrDefault(gg, 0) + 1);
        }

        int result = 0;
        for (int ss : s) {
            if (hashMap.containsKey(ss)) {
                int getNumber = hashMap.get(ss);
                if (getNumber != 0) {
                    hashMap.put(ss, getNumber - 1);
                    result++;
                }
            }
        }
        return result;
    }
}
