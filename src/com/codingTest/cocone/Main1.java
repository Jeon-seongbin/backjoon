package com.codingTest.cocone;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        solution("abc");
    }

    public static String solution(String sentence) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        hashMap.put('a', 0);
        hashMap.put('b', 0);
        hashMap.put('c', 0);
        hashMap.put('d', 0);
        hashMap.put('e', 0);
        hashMap.put('f', 0);
        hashMap.put('g', 0);
        hashMap.put('h', 0);
        hashMap.put('i', 0);
        hashMap.put('j', 0);
        hashMap.put('k', 0);
        hashMap.put('l', 0);
        hashMap.put('m', 0);
        hashMap.put('n', 0);
        hashMap.put('o', 0);
        hashMap.put('p', 0);
        hashMap.put('q', 0);
        hashMap.put('r', 0);
        hashMap.put('s', 0);
        hashMap.put('t', 0);
        hashMap.put('u', 0);
        hashMap.put('v', 0);
        hashMap.put('w', 0);
        hashMap.put('x', 0);
        hashMap.put('y', 0);
        hashMap.put('z', 0);

        for (char c : sentence.toCharArray()) {
            if (65 <= c && c <= 90) {
                c += 32;
            }
            hashMap.put(c, 1);
        }


        if (hashMap.containsValue(0)) {
            String result = "";

            for (Map.Entry e : hashMap.entrySet()) {

                int value = (int) e.getValue();
                if (value == 0) {
                    result += e.getKey();
                }
            }

            char[] cc = result.toCharArray();

            Arrays.sort(cc);



            result = "";
            for (char c : cc) {
                result += c;
            }
            return result;

        }
        return "perfect";


    }
}
