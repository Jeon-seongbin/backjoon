package com.company20;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main6 {
    public static int bigCount = 0;
    public static int smallCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bigCount = Integer.parseInt(br.readLine());

        for (int test = 0; test < bigCount; test++) {
            smallCount = Integer.parseInt(br.readLine());

            // 우선순위 저장
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int test1 = 0; test1 < smallCount; test1++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                String testCase = st.nextToken();
                int testCaseNumber = Integer.parseInt(st.nextToken());

                if (testCase.equals("I")) {

                    map.put(testCaseNumber, map.getOrDefault(testCaseNumber, 0) + 1);

                } else {
                    if (map.size() == 0) continue;
                    int deleteNumber = 0;
                    if (testCaseNumber == 1) {
                        deleteNumber = map.lastKey();
                    } else {
                        deleteNumber = map.firstKey();
                    }
                    if (map.containsKey(deleteNumber)) {
                        map.put(deleteNumber, map.get(deleteNumber) - 1);
                        if (map.get(deleteNumber) == 0) {
                            map.remove(deleteNumber);
                        }
                    } else {
                        map.remove(deleteNumber);
                    }
                }
            }
            if (map.size() == 0) {
                bw.write("EMPTY\n");
            } else {
                bw.write("" + map.lastKey() + " " + map.firstKey() + "\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}