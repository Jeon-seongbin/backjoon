package com.leetcode.midium;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BuddyStrings859 {
    public static void main(String[] args) {
        buddyStrings("czabaai", "caabazi");
    }

    public static boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        Map<Character, Integer> mapS = new HashMap<>();
        ArrayList<Integer> pos = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char ss = s.charAt(i);
            char gg = goal.charAt(i);

            if (ss != gg) {
                pos.add(i);
            }
            mapS.put(ss, mapS.getOrDefault(ss, 0) + 1);

        }

        if (s.equals(goal)) {
            for (char ss : mapS.keySet()) {
                if (1 < mapS.get(ss)) {
                    return true;
                }
            }
            return false;
        }

        if (pos.size() != 2) {
            return false;
        }
        int posOne = pos.get(0);
        int posTwo = pos.get(1);
        return s.charAt(posOne) == goal.charAt(posTwo) && s.charAt(posTwo) == goal.charAt(posOne);
    }
}
