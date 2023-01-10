package com.acmicpc.season1.company8;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

// https://www.acmicpc.net/problem/1717
// 집합의 표현
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = bf.readLine();

        String[] inputs = input.split(" ");
        //초기에 {0}, {1}, {2}, ... {n} 이 각각 n+1개의 집합을 이루고 있다.
        int n = Integer.parseInt(inputs[0]);
        n++;
        int[] arr = new int[n];

        int m = Integer.parseInt(inputs[1]);
        //m은 입력으로 주어지는 연산의 개수이다.

        HashSet<Integer> hapJibHap = new HashSet<>();

        for (int i = 0; i < m; i++) {
            input = bf.readLine();
            inputs = input.split(" ");
            int zeroOrOne = Integer.parseInt(inputs[0]);
            int a = Integer.parseInt(inputs[1]);
            int b = Integer.parseInt(inputs[2]);

            ArrayList<Integer> hapJibHapTemp = new ArrayList<>();

            if (zeroOrOne == 0) {

                hapJibHapTemp.add(a);
                hapJibHapTemp.add(b);

                hapJibHap.addAll(hapJibHapTemp);

            } else {

                if (hapJibHap.contains(a)) {
                    if (hapJibHap.contains(b)) {
                        bw.write("YES\n");
                        hapJibHap = new HashSet<>();
                    } else {
                        bw.write("NO\n");
                        hapJibHap = new HashSet<>();
                    }
                } else {
                    bw.write("NO\n");
                    hapJibHap = new HashSet<>();
                }

            }
        }

        bw.flush();
        bw.close();
        bf.close();
    }
}

