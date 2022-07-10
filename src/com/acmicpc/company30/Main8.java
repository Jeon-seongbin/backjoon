package com.acmicpc.company30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main8 {
    public static int N;
    static final int MAX = 100000;
    public static int[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] power = new int[MAX + 1];
        for (int i = 1; i <= MAX; i++) {
            power[i] = i * i;
        }

        int start = 1;
        int end = 2;
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (end <= MAX) {
            long weight = power[end] - power[start];
            if (weight == N) {
                result.add(end);
            }
            if (weight > N) {
                start++;
            }
            if (weight <= N) {
                end++;
            }
        }
        Collections.sort(result);
        if (result.isEmpty() || N == 1) {
            System.out.println(-1);
        } else {
            for (int ele : result) {
                System.out.println(ele);
            }
        }
    }
}
