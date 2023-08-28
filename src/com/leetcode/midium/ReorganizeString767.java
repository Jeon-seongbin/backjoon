package com.leetcode.midium;

import java.util.HashMap;
import java.util.PriorityQueue;

public class ReorganizeString767 {
    public static void main(String[] args) {
        reorganizeString("aaaaz");
    }

    public static String reorganizeString(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> hashMap.get(b) - hashMap.get(a));

        for (char c : s.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        for (char c : hashMap.keySet()) {
            maxHeap.offer(c);
        }

        char[] result = new char[s.length()];
        int resultIndex = 0;

        char maeNoChar = 0;

        while (!maxHeap.isEmpty()) {
            char nowCh = maxHeap.poll();
            int nowChCount = hashMap.get(nowCh) - 1;
            hashMap.put(nowCh, nowChCount);

            result[resultIndex++] = nowCh;
            if (maeNoChar > 0) {
                maxHeap.add(maeNoChar);
            }

            if (nowChCount > 0) {
                maeNoChar = nowCh;
            } else {
                maeNoChar = 0;
            }
        }
        if (maeNoChar != 0) {
            return "";
        }
        return new String(result);
    }

}
