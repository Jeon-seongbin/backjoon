package com.leetcode.midium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class OpenTheLock752 {
    public static void main(String[] args) {

    }

    public int openLock(String[] deadends, String target) {
        HashSet<String> deadEnds = new HashSet<>(Arrays.asList(deadends));
        HashSet<String> isVisited = new HashSet<>();

        Queue<String> queue = new LinkedList<>();

        isVisited.add("0000");
        queue.add("0000");

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                String now = queue.poll();
                if (deadEnds.contains(now)) {
                    size--;
                    continue;

                }

                if (target.equals(now)) {
                    return level;
                }

                StringBuilder sb = new StringBuilder(now);
                for (int i = 0; i < 4; i++) {
                    char currentPosition = sb.charAt(i);
                    String s1 = sb.substring(0, i) + (currentPosition == '9' ? 0 : currentPosition - '0' + 1) + sb.substring(i + 1);
                    String s2 = sb.substring(0, i) + (currentPosition == '0' ? 9 : currentPosition - '0' - 1) + sb.substring(i + 1);

                    if (!isVisited.contains(s1) && !deadEnds.contains((s1))) {
                        queue.offer(s1);
                        isVisited.add(s1);
                    }


                    if (!isVisited.contains(s2) && !deadEnds.contains((s2))) {
                        queue.offer(s2);
                        isVisited.add(s2);
                    }
                }
                size--;

            }
            level++;

        }
        return -1;
    }
}
