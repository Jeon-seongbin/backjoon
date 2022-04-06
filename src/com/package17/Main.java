package com.package17;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2606
public class Main {
    public static int N, M, count = 0;
    public static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    public static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫째 줄에는 컴퓨터의 수가 주어진다. 컴퓨터의 수는 100 이하이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다.
        N = Integer.parseInt(br.readLine());

        // 둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다.
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < N + 1; i++) {
            arrayList.add(new ArrayList<>());
        }
        isVisited = new boolean[N + 1];

        // 이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            arrayList.get(n).add(m);
            arrayList.get(m).add(n);
        }
        dfs(1);
        bw.write("" + (count - 1));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int v) {
        // 1번 컴퓨터가 웜 바이러스에 걸렸을 때,
        // 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력한다.

        count++;
        ArrayList<Integer> a = arrayList.get(v);
        isVisited[v] = true;
        for (int i = 0; i < a.size(); i++) {
            int aa = a.get(i);
            if (isVisited[aa]) {
                continue;
            }
            dfs(aa);
        }
    }
}
