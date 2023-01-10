package com.acmicpc.season1.company7;

import java.io.*;
import java.util.HashMap;

// 10815
public class Main4 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bf.readLine();
        String sCard = bf.readLine();

        String[] sCards = sCard.split(" ");

        bf.readLine();
        String checkNumber = bf.readLine();

        String[] checkNumbers = checkNumber.split(" ");

        HashMap<String, Integer> sCardHashMap = new HashMap<>();

        for (String s : sCards) {
            if (!sCardHashMap.containsKey(s)) {
                sCardHashMap.put(s, 1);
            } else {
                int sCount = sCardHashMap.get(s);
                sCardHashMap.put(s, ++sCount);
            }
        }

        for (String c : checkNumbers) {
            if (sCardHashMap.containsKey(c)) {
                bw.write("" + sCardHashMap.get(c));
            } else {
                bw.write("" + 0);
            }
            bw.write(" ");
        }
        bw.flush();
        bw.close();
        bf.close();
    }
}
