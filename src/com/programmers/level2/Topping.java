package com.programmers.level2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Topping {
    public static void main(String[] args) {
        solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2});
    }

    public static int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int t : topping) {
            hashMap.put(t, hashMap.getOrDefault(t, 0) + 1);
        }

        for (int t : topping) {
            if (hashMap.get(t) == 1) {
                hashMap.remove(t);
            } else {
                hashMap.put(t, hashMap.get(t) - 1);
            }
            set.add(t);
            if (set.size() == hashMap.size()) {
                answer++;
            }
        }

        return answer;
    }
}
