package com.leetcode.midium;

import java.util.*;
import java.util.stream.Collectors;

public class FindPlayersWithZeroOrOneLosses2225_1 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> findWinners(int[][] matches) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int[] match : matches) {
            hashMap.put(match[1], hashMap.getOrDefault(match[1], 0) + 1);
            hashMap.put(match[0], hashMap.getOrDefault(match[0], 0));
        }

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> a = hashMap.entrySet().stream().filter(obj -> obj.getValue() == 1).map(obj -> obj.getKey()).collect(Collectors.toList());
        List<Integer> b = hashMap.entrySet().stream().filter(obj -> obj.getValue() == 0).map(obj -> obj.getKey()).collect(Collectors.toList());

        Collections.sort(a);
        Collections.sort(b);

        ans.add(b);
        ans.add(a);

        return ans;

    }
}
