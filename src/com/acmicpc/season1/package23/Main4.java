package com.acmicpc.season1.package23;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main4 {
    public static ArrayList<ArrayList<Tree18227>> arrayList = new ArrayList<>();

    //도시의 수 N (1 ≤ N ≤ 200,000)과
    public static int N;

    public static boolean[] isVisited;

    // 수도의 번호 C (1 ≤ C ≤ N)가 공백으로 구분되어 주어진다.
    public static int C;


    //Q개의 줄에 질의가 들어온다.
    public static int Q;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N + 1; i++) {
            arrayList.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int root = Integer.parseInt(st.nextToken());
            int doshi = Integer.parseInt(st.nextToken());
            arrayList.get(root).add(new Tree18227(doshi, 0));
        }
        arrayList.get(0).add(new Tree18227(C, 0));


        Q = Integer.parseInt(br.readLine());

        for (int i = 0; i < Q - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int targetDoshi = Integer.parseInt(st.nextToken());

            if (first == 1) {
                // 1 A : A도시에 물을 채운다.

                isVisited = new boolean[N + 1];
                fillWater(C, targetDoshi, 1);
            } else {
                // 2 A : 현재 A도시에 얼마만큼의 물이 채워져 있는지 출력하라.

                isVisited = new boolean[N + 1];
                search(targetDoshi);
            }
        }
    }

    public static int search(int target) {
        if (target == C) {
            int a = arrayList.get(0).get(0).mizu;
            System.out.println(a);
            return a;
        }
        searchWater(1, target);
        return 0;
    }

    public static void searchWater(int root, int target) {


        for (int i = 0; i < arrayList.get(root).size(); i++) {
            int nextDoshi = arrayList.get(root).get(i).doshi;

            if (isVisited[nextDoshi]) {
                continue;
            }
            if (nextDoshi == target) {
                Tree18227 a = arrayList.get(root).get(i);
                System.out.println(a.mizu);
                return;
            }
            isVisited[nextDoshi] = true;
            searchWater(nextDoshi, target);
        }
    }


    public static void fillWater(int nowNumber, int target, int depth) {
        if (isVisited[nowNumber]) {
            return;
        }

        if (nowNumber == C) {
            int a = arrayList.get(0).get(0).mizu;
            arrayList.get(0).get(0).mizu = a + 1;
        }
        if (nowNumber == target) {

            return;
        }


        ArrayList<Tree18227> root = arrayList.get(nowNumber);
        isVisited[nowNumber] = true;

        for (int i = 0; i < root.size(); i++) {
            int nextNumber = root.get(i).doshi;
            root.get(i).mizu = depth + 1;
            fillWater(nextNumber, target, depth + 1);

        }
    }
}

class Tree18227 {
    int doshi;
    int mizu;

    Tree18227(int doshi, int mizu) {
        this.doshi = doshi;
        this.mizu = mizu;
    }
}