package com.company10;

import java.io.*;
import java.util.*;
// https://www.acmicpc.net/problem/1159
public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < count; i++) {
            char a = br.readLine().charAt(0);
            if (hashMap.containsKey(a)) {
                int count1 = hashMap.get(a);
                hashMap.put(a, ++count1);
            } else {
                hashMap.put(a, 1);
            }
        }

        ArrayList<Character> result = new ArrayList<>();
        for (Map.Entry<Character, Integer> map : hashMap.entrySet()) {
            if (5 <= map.getValue()) {
                result.add(map.getKey());
            }
        }

        Collections.sort(result);
        if(result.isEmpty()){
            bw.write("PREDAJA");
        }else{
            for(int i = 0 ; i < result.size();i++){
                bw.write(result.get(i));
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
