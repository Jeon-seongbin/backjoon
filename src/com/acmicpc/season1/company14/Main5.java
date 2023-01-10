package com.acmicpc.season1.company14;

import java.util.ArrayList;
import java.util.Arrays;

public class Main5 {
    private ArrayList<ArrayList<Integer>> listGraph;
    private boolean[] visitArr;
    private int nV;

    public Main5(int initSize) {
        this.nV = initSize;
        this.listGraph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < initSize + 1; i++) {
            this.listGraph.add(new ArrayList<Integer>());
        }
        this.visitArr = new boolean[this.nV + 1];
    }

    public ArrayList<ArrayList<Integer>> getListGraph() {
        return this.listGraph;
    }

    public ArrayList<Integer> getNode(int i) {
        return this.listGraph.get(i);
    }

    public void put(int x, int y) {
        this.listGraph.get(x).add(y);
        this.listGraph.get(y).add(x);
    }

    public void putSingle(int x, int y) {
        this.listGraph.get(x).add(y);
    }

    // 그래프 출력 (인접리스트)
    public void printGraphToAdjList() {

        for (int i = 1; i < listGraph.size(); i++) {
            for (int j = 0; j < listGraph.get(i).size(); j++) {
                System.out.print(" -> " + listGraph.get(i).get(j));
            }
            System.out.println();
        }
    }

    // 정점 방문 여부 확인 배열 초기화
    public void clearVisitArr() {
        Arrays.fill(this.visitArr, false);
    }

    public void dfs(int vIdx) {
        this.visitArr[vIdx] = true;
        System.out.print(vIdx + " ");

        for (int i : this.listGraph.get(vIdx)) {
            if (!this.visitArr[i]) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) {
        int initSize = 8;
        Main5 adjList = new Main5(initSize);

        adjList.put(1, 2);
        adjList.put(1, 3);
        adjList.put(2, 4);
        adjList.put(2, 5);
        adjList.put(3, 6);
        adjList.put(3, 7);
        adjList.put(4, 8);
        adjList.put(5, 8);
        adjList.put(6, 8);
        adjList.put(7, 8);


        adjList.printGraphToAdjList();

        // 정점 순서대로 그래프 탐색
        System.out.println();
        System.out.print("정점 1부터 탐색 : ");
        adjList.dfs(1);
    }
}
