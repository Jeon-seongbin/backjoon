package com.acmicpc.package17;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11403
public class Main2 {
    public static int count;
    public static int[][] map;
    public static int[][] result;

    public static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        count = Integer.parseInt(br.readLine());
        map = new int[count][count];
        result = new int[count][count];
//        isVisited = new boolean[count];

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < count; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                if (result[i][j] == 1) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void bfs() {

        for (int i = 0; i < count; i++) {
            // 전체 정점 반복

            Queue<Integer> q = new LinkedList<>();
            q.add(i);

            isVisited = new boolean[count];
            // 각 정점에서 어디로 갈 지 모르니 정점 마다 초기화

            while (!q.isEmpty()) {
                int temp = q.poll();

                for (int j = 0; j < count; j++) {
                    if (map[temp][j] == 1 && !isVisited[j]) {

                        isVisited[j] = true;
                        q.add(j);
                        result[i][j] = 1;
                        // 만약 i 에서 j 의 정점을 거친다면 추가
                        // temp 가 되면 현재 찍은게 됨
                    }
                }
            }
        }
    }

}

