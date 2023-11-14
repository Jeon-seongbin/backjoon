package com.leetcode.midium;

import java.util.PriorityQueue;

public class SortVowelsInAString2785 {
    public static void main(String[] args) {
        String a = sortVowels("lEetcOde");
        System.out.println(a);

    }

    public static String sortVowels(String s) {
        PriorityQueue<Character> pq = new PriorityQueue<>();

        for (char a : s.toCharArray()) {
            if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u' || a == 'A' || a == 'E' || a == 'I' || a == 'O' || a == 'U') {
                pq.add(a);
            }
        }


        String result = "";

        for (char a : s.toCharArray()) {
            if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u' || a == 'A' || a == 'E' || a == 'I' || a == 'O' || a == 'U') {
                result += pq.poll();
            } else {
                result += a;
            }
        }
        return result;
    }
}
