package com.company11;

import java.io.*;
import java.util.Arrays;

// 이분탐색
// https://www.acmicpc.net/problem/3273
public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int resultCount = Integer.parseInt(br.readLine());
        int result = 0;

        int[] arr1 = new int[count];

        for (int i = 0; i < count; i++) {
            arr1[i] = Integer.parseInt(arr[i]);
        }

        Arrays.sort(arr1);

        for (int i = 0; i < count; i++) {
            for (int j = count - 1; j > i; j--) {
                int plus = arr1[i] + arr1[j];

                if (resultCount == plus) {
                    result++;
                    break;
                }
            }
        }

        bw.write("" + result);
        bw.flush();
        bw.close();
        br.close();
    }
}
