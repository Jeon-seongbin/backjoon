package com.acmicpc.company30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main8 {
    public static int N;
    public static int[] input;
    public static int maxG = 100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = new int[maxG + 1];

        for (int i = 1; i <= maxG; i++) {
            input[i] = i * i;
        }

        int start = 1;
        int end = 2;
        ArrayList<Integer> arrayList = new ArrayList<>();

        while (end <= maxG) {
            int result = input[end] - input[start];
            if (result == N) {
                arrayList.add(end);
            }
            if (result <= N) {
                end++;
            }
            if (result > N) {
                start++;
            }
        }

        Collections.sort(arrayList);
        if (arrayList.isEmpty() || N == 1) {
            System.out.println(-1);
        } else {
            for (int ele : arrayList) {
                System.out.println(ele);
            }
        }

    }
}
