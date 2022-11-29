package com.leetcode.midium;

import java.util.*;
import java.util.stream.Collectors;

public class FindPlayersWithZeroOrOneLosses2225 {
    public static void main(String[] args) {
        findWinners(new int[][]{{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}});
    }

    public static List<List<Integer>> findWinners(int[][] matches) {

        HashMap<Integer, Integer> t1 = new HashMap<>();
        HashMap<Integer, Integer> t2 = new HashMap<>();

        for (int i = 0; i < matches.length; i++) {
            t1.put(matches[i][0], t1.getOrDefault(matches[i][0], 0) + 1);
        }

        for (int i = 0; i < matches.length; i++) {
            t2.put(matches[i][1], t2.getOrDefault(matches[i][1], 0) + 1);
        }

        List<Integer> r1 = t1.entrySet().stream().filter(obj -> t2.containsKey(obj.getKey()) == false).map(Map.Entry::getKey).collect(Collectors.toList());
        List<Integer> r2 = t2.entrySet().stream().filter(obj -> obj.getValue() == 1).map(Map.Entry::getKey).collect(Collectors.toList());
        List<List<Integer>> result = new ArrayList<>();
        Collections.sort(r1);
        Collections.sort(r2);

        result.add(r1);
        result.add(r2);

        return result;

    }
}
