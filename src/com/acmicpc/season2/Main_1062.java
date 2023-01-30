package com.acmicpc.season2;

import java.io.*;
import java.util.StringTokenizer;

public class Main_1062 {
    public static int N;
    public static int K;
    public static String[] subString;
    public static boolean[] isVisited = new boolean[26];
    public static int[] numbers;

    public static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        subString = new String[N];
        if (K < 5) {
            System.out.println(0);
            return;
        }

        if (K == 26) {
            System.out.println(N);
            return;
        }

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            subString[i] = str.substring(4, str.length() - 4);
        }

        isVisited['a' - 97] = true;
        isVisited['n' - 97] = true;
        isVisited['t' - 97] = true;
        isVisited['i' - 97] = true;
        isVisited['c' - 97] = true;

        numbers= new int[K - 5];
        combination(0,0);
        System.out.println(max);
    }

    public static void combination(int idx, int start) {

        if (idx == K - 5) {
            int count = 0;

            for (int i = 0; i < N; i++) {
                boolean isValid = true;
                for (int j = 0; j < subString[i].length(); j++) {
                    if (!isVisited[subString[i].charAt(j) - 97]) {
                        isValid = false;
                        break;
                    }
                }
                if (isValid) {
                    count++;
                }

            }
            max = Math.max(max, count);
            return;
        }


        for (int i = start; i < 26; i++) {
            if (isVisited[i]) {
                continue;
            }

            isVisited[i] = true;
            combination(idx + 1, i + 1);
            isVisited[i] = false;

        }

    }
}
