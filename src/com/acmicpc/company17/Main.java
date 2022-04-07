package com.acmicpc.company17;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/2667
public class Main {
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Point> q;
    static int count;
    static int userInput;
    static ArrayList<Integer> arrayList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        userInput = Integer.parseInt(br.readLine());

        map = new int[userInput][userInput];
        visit = new boolean[userInput][userInput];
        q = new LinkedList<>();
        arrayList = new ArrayList<>();

        for (int i = 0; i < userInput; i++) {
            String a = br.readLine();
            for (int j = 0; j < userInput; j++) {

                map[i][j] = Integer.parseInt(String.valueOf(a.charAt(j)));

                if (map[i][j] == 1) {
                    visit[i][j] = true;
                }

            }
        }
        bfs();
        bw.write("" + count+"\n");
        for(int i = 0 ; i < count; i++){
            bw.write("" + arrayList.get(i)+"\n");
        }
        br.close();
        bw.close();
    }

    static void bfs() {

        for (int i = 0; i < userInput; i++) {
            for (int j = 0; j < userInput; j++) {
                if (visit[i][j] && map[i][j] != 0) {
                    int zoneCount = 0;
                    count++;
                    q.offer(new Point(i, j));
                    while (!q.isEmpty()) {
                        Point p = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int newX = p.x + dx[k];
                            int newY = p.y + dy[k];

                            if (newX < 0 || userInput <= newX || newY < 0 || userInput <= newY) {
                                continue;
                            }

                            if (map[newX][newY] == 1 && visit[newX][newY]) {
                                q.offer(new Point(newX, newY));
                                visit[newX][newY] = false;
                                zoneCount++;
                            }
                        }
                    }
                    if(zoneCount == 0){zoneCount++;}
                    arrayList.add(zoneCount);
                }

            }
        }
        Collections.sort(arrayList);



    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
