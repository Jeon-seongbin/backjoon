package com.acmicpc.company26;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main4 {
    public static ArrayList<ArrayList<Integer>> tree;
    public static boolean[] isVisited;
    public static int deleteNumber = 0;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int userInput = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        isVisited = new boolean[userInput];

        int root = 0;
        for (int i = 0; i < userInput; i++) {
            tree.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < userInput; i++) {
            int jj = Integer.parseInt(st.nextToken());

            if (jj != -1) {
                tree.get(i).add(jj);
                tree.get(jj).add(i);
            } else {
                root = i;
            }
        }
        deleteNumber = Integer.parseInt(br.readLine());

        if (deleteNumber != root) {
            dfs(root);
        }

        bw.write("" + answer);
        bw.flush();
    }

    public static void dfs(int root) {

        isVisited[root] = true;
        int childNum = 0;
        for (int i = 0; i < tree.get(root).size(); i++) {
            int next = tree.get(root).get(i);
            if (!isVisited[next] && next != deleteNumber) {
                childNum++;
                dfs(next);
            }
        }
        if (childNum == 0) {
            answer++;
        }
    }
}
