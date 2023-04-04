package com.leetcode.midium;

import java.util.HashSet;
import java.util.Set;

public class OptimalPartitionofString2405 {
    public static void main(String[] args) {

    }

    public static int partitionString(String s) {
        int count = 0;
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.clear();
                count++;
            }
            set.add(c);
        }
        return count + 1;
    }
}
