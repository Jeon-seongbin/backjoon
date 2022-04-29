package com.acmicpc.company23;

import java.io.*;
import java.util.ArrayList;

public class Main3 {
    public static int N;
    public static ArrayList<Integer> arrayList = new ArrayList<>();
    public static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫째 줄에 자연수 N이 주어진다. (1 ≤ N ≤ 4,000,000)
        N = Integer.parseInt(br.readLine());
//        array = new int[4000001];

        isPrime = new boolean[4000001];

//        int arrayIndex = 0;
//        isPrime[0] = isPrime[1] = true;
        for (int i = 2; i * i <= N; i++) {
            if (!isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = true;
                }
            }
        }
        for (int i = 2; i <= N; i++) {
            if (!isPrime[i]) {
//                array[arrayIndex] = i;
//                arrayIndex++;
                arrayList.add(i);
            }

        }
//
//        for (int i = 2; i <= N; i++) {
//            boolean isIPrime = true;
//            for (int j = 2; j < i; j++) {
//                if (i % j == 0) {
//                    isIPrime = false;
//                    break;
//                }
//            }
//            if (isIPrime) {
//                array[arrayIndex] = i;
//                arrayIndex++;
//            }
//        }

        int start = 0;
        int end = 0;
        int count = 0;
        int sum = 0;
        if (N == 1) {
            bw.write("0");
            bw.flush();
            return;
        }
        while (true) {
            if (N < sum) {
//                sum -= array[end];
                sum -= arrayList.get(end);
                end++;
            } else if (start  == arrayList.size()) {
                break;
            } else {
//                sum += array[start];
                sum += arrayList.get(start);
                start++;
            }
            if (N == sum) {
                count++;
            }
        }

        bw.write("" + count);
        bw.flush();
        bw.close();
        br.close();
    }
}
