package com.leetcode.midium;

import java.util.*;

public class TopKFrequentWords692 {
    public static void main(String[] args) {

    }

    public List<String> topKFrequent1(String[] words, int k) {

        HashMap<String, Integer> hashmap = new HashMap<>();
        for (String word : words) {
            hashmap.put(word, hashmap.getOrDefault(word, 0) + 1);
        }

        // add key (unsorted)
        List<String> result = new ArrayList<>(hashmap.keySet());

        // sort with key
        Collections.sort(result, (A1, A2) ->
                hashmap.get(A1) == hashmap.get(A2) // check value
                        ? A1.compareTo(A2)  // if value (count) same check keys (one with lower alphabetical order comes first(lexicographical order))
                        : hashmap.get(A2) - hashmap.get(A1) // else most value (count) will first
        );

        // 1 이면
        // 0 이면 가만히 있는다
        // -1이면 바꾼다
        return result.subList(0, k);
    }

    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String word : words) {
            hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (hashMap.get(a) == hashMap.get(b)) {
                        return b.compareTo(a);
                    }
                    return hashMap.get(a) - hashMap.get(b);
                });


        for (String s : hashMap.keySet()) {
            pq.offer(s);
            if (k < pq.size()) {
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            result.add(0, pq.poll());
        }

        return result;

    }
}
