package com.leetcode.midium;

import java.util.HashMap;
import java.util.TreeMap;

public class HandofStraights846 {
    public static void main(String[] args) {

    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand == null || hand.length == 0 || groupSize == 0) {
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int h : hand) {
            map.put(h, map.getOrDefault(h, 0) + 1);
        }


        for (int card : map.keySet()) {
            int count = map.get(card);

            if (0 < count) {
                for (int i = 0; i < groupSize; i++) {
                    if (map.getOrDefault(card + i, 0) < count) {
                        return false;
                    }
                    map.put(card + i, map.get(card + i) - count);
                }
            }
        }
        return true;
    }
}
