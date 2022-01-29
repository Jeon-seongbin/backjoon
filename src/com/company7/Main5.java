package com.company7;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main5 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();
        String A = br.readLine();
        String B = br.readLine();

        String[] as = A.split(" ");
        String[] bs = B.split(" ");

        HashMap<String, String> hashMap = new HashMap<>();

        for (String a : as) {
            hashMap.put(a, a);
        }

        for (String b : bs) {
            hashMap.remove(b);
        }

        if (hashMap.isEmpty()) {
            bw.write("0");
        } else {
            String[] keys = new String[hashMap.size()];
            Integer[] values = new Integer[hashMap.size()];
            int index = 0;
            for (Map.Entry<String, String> mapEntry : hashMap.entrySet()) {
                keys[index] = mapEntry.getKey();
                values[index] = Integer.parseInt(mapEntry.getValue());
                index++;
            }
            Arrays.sort(values);
            bw.write("" + values.length + "\n");
            for (int a : values) {
                bw.write("" + a + " ");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
