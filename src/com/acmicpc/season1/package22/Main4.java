package com.acmicpc.season1.package22;

import java.io.*;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main4 {
    public static ArrayList<Node22856>[] arrayList;
    public static ArrayList<Integer> inOrder;
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int userInput = Integer.parseInt(st.nextToken());
        arrayList = new ArrayList[userInput + 1];
        for (int i = 0; i <= userInput; i++) {
            arrayList[i] = new ArrayList<>();
        }

        for (int i = 0; i < userInput; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            arrayList[a].add(new Node22856(l, r));
        }

        inOrder = new ArrayList<>();
        dfs(1, 0, true);
        dfs(1, 0, false);
    }

    public static void dfs(int here, int parents, boolean f) {
        for (Node22856 now : arrayList[here]) {

            if (now.left != -1) {
                dfs(now.left, here, f);
                if (!f) {
                    count++;
                }
            }
            if (f) {
                inOrder.add(here);
            } else {
                if (inOrder.get(inOrder.size() - 1) == here) {
                    System.out.println(count);
                    return;
                }
                count++;
            }

            if (now.right != -1) {
                dfs(now.right, here, f);
                if (!f) count++;
            }
        }
    }
}

class Node22856 {
    int left;
    int right;

    public Node22856(int left, int right) {
        this.left = left;
        this.right = right;
    }
}