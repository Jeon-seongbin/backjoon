package com.acmicpc.company7;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main7 {
    public static void main(String[] args) throws IOException {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('b', 0);
        map.put('c', 0);
        map.put('d', 0);
        map.put('e', 0);
        map.put('f', 0);
        map.put('g', 0);
        map.put('h', 0);
        map.put('i', 0);
        map.put('j', 0);
        map.put('k', 0);
        map.put('l', 0);
        map.put('m', 0);
        map.put('n', 0);
        map.put('o', 0);
        map.put('p', 0);
        map.put('q', 0);
        map.put('r', 0);
        map.put('s', 0);
        map.put('t', 0);
        map.put('u', 0);
        map.put('v', 0);
        map.put('w', 0);
        map.put('x', 0);
        map.put('y', 0);
        map.put('z', 0);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String userInput = br.readLine();

        for (int i = 0; i < userInput.length(); i++) {
            char a = userInput.charAt(i);
            if (map.containsKey(a)) {
                int count = map.get(a);
                map.put(a, ++count);
            }
        }
        int index = 0;
        for (Map.Entry<Character, Integer> mapEntry : map.entrySet()) {
            mapEntry.getKey();
            int value = mapEntry.getValue();
            bw.write("" + value + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
