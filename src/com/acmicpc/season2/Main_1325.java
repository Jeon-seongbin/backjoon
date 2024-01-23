package com.acmicpc.season2;

import java.io.*;
import java.util.ArrayList;

public class Main_1325 {


    public static int N;
    public static int M;
    public static ArrayList<ArrayList<Integer>> arrayList;
    public static int[] check;
    public static int max;
    public static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] userInput = br.readLine().split(" ");
        max = Integer.MIN_VALUE;

//        /*
//           N개의 컴퓨터로 이루어져 있다.
//           첫째 줄에, N과 M이 들어온다. N은 10,000보다 작거나 같은 자연수, M은 100,000보다 작거나 같은 자연수이다.
//           둘째 줄부터 M개의 줄에 신뢰하는 관계가 A B와 같은 형식으로 들어오며, "A가 B를 신뢰한다"를 의미한다. 컴퓨터는 1번부터 N번까지 번호가 하나씩 매겨져 있다.
//         */
        N = Integer.parseInt(userInput[0]);
        M = Integer.parseInt(userInput[1]);

        arrayList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            arrayList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            userInput = br.readLine().split(" ");
            int from = Integer.parseInt(userInput[0]);
            int to = Integer.parseInt(userInput[1]);
            arrayList.get(to).add(from);
        }

        check = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            isVisited = new boolean[N + 1];

            isVisited[i] = true;
            dfs(i, i);
        }

        for (int i = 0; i < check.length; i++) {
            if (max == check[i]) {
                bw.write("" + i);
                bw.write(" ");

            }
        }


        bw.flush();
        bw.close();
        br.close();

        /*
            5 4
            3 1
            3 2
            4 3
            5 3
         */
    }

    public static void dfs(int original, int now) {
        for(int next  : arrayList.get(now)){

//        }
//        for (int i = 0; i < arrayList.get(now).size(); i++) {
//            int next = arrayList.get(now).get(i);
            if (isVisited[next]) {
                continue;
            }
            check[original]++;
            if (max < check[original]) {
                max = check[original];
            }
            isVisited[next] = true;
            dfs(original, next);

        }
    }


}
