package com.acmicpc.company31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 텀 프로젝트
public class Main {
    public static ArrayList<ArrayList<Integer>> arrayList;
    public static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        for (int testCount = 0; testCount < count; testCount++) {


            int count1 = Integer.parseInt(br.readLine());
            int resultCount = 0;
            arrayList = new ArrayList<>();
            isVisited = new boolean[count1 + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i <= count1; i++) {
//              Integer.parseInt(st.nextToken());
                arrayList.add(new ArrayList<>());
            }

            for (int i = 1; i <= count1; i++) {
                int jj = Integer.parseInt(st.nextToken());
                arrayList.get(i).add(jj);
//                arrayList.get(jj).add(i);
            }

            for (int i = 1; i <= count1; i++) {
                int result = 0;
//                if (isVisited[i]) {
//                    continue;
//                }
                isVisited[i] = true;
                result = dfs(i, 0);
                if (result == 1) {
                    resultCount++;
                }

            }

            System.out.println(resultCount);
        }
    }

    public static int dfs(int node, int depth) {
        int result = 0;
        for (int a : arrayList.get(node)) {
            if (isVisited[a]) {

                return depth;
            }
            isVisited[a] = true;
            result = dfs(a, depth + 1);
        }

        return result;
    }
}
