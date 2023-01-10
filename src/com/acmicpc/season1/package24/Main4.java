package com.acmicpc.season1.package24;

import java.io.*;
import java.util.StringTokenizer;

public class Main4 {

    public static int[] input;
    public static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                break;
            }
            input = new int[n];
            isVisited = new boolean[n];
            for (int i = 0; i < n; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0);
            System.out.println();
        }
    }


    public static void dfs(int index, int count) {

        if (count == 6) {
            for (int i = 0; i < input.length; i++) {
                if (isVisited[i]) {
                    System.out.print(input[i] + " ");
                }
            }
            System.out.println();
        }

        for (int i = index; i < input.length; i++) {
            isVisited[i] = true;
            dfs(i + 1, count + 1);
            isVisited[i] = false;
        }
    }
}
