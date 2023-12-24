package com.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class PathCrossing1496 {

    public static void main(String[] args) {
        isPathCrossing("NESWW");
    }

    public static boolean isPathCrossing(String path) {


        Set<String> set = new HashSet<>();

        set.add("0,0");
        int x = 0;
        int y = 0;

        for (char p : path.toCharArray()) {
            switch (p) {
                case 'E':
                    x++;

                    break;
                case 'W':
                    x--;

                    break;
                case 'S':
                    y--;

                    break;
                case 'N':
                    y++;

                    break;
            }

            String newPoint = x + "," + y;
            if (set.contains(newPoint)) {
                return true;
            }
            set.add(newPoint);



        }
        return false;
    }
}
