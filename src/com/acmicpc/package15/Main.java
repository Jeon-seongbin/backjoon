package com.acmicpc.package15;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static char[][] rgb;
    static boolean[][] visit;

    static char[][] rgb2;
    static boolean[][] visit2;

    static int[] dn = {1, 0, -1, 0};
    static int[] dm = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int userInput = Integer.parseInt(br.readLine());


        rgb = new char[userInput][userInput];
        visit = new boolean[userInput][userInput];

        rgb2 = new char[userInput][userInput];
        visit2 = new boolean[userInput][userInput];

        for (int i = 0; i < userInput; i++) {
            String userInputStr = br.readLine();
            for (int j = 0; j < userInput; j++) {
                char color = userInputStr.charAt(j);
                rgb[i][j] = color;

                if (color == 'G') {
                    color = 'R';
                }
                rgb2[i][j] = color;

            }
        }

        int answer = 0;
        int answer2 = 0;
        for (int i = 0; i < userInput; i++) {
            for (int j = 0; j < userInput; j++) {
                if (!visit[i][j]) {
                    bfs(new Point(i, j));
                    answer++;
                }
            }
        }

        for (int i = 0; i < userInput; i++) {
            for (int j = 0; j < userInput; j++) {
                if (!visit2[i][j]) {
                    bfs2(new Point(i, j));
                    answer2++;
                }
            }
        }

        bw.write("" + answer + " " + answer2);
        br.close();
        bw.close();
    }

    public static void bfs(Point point) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(point);
        visit[point.x][point.y] = true;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newN = p.x + dn[i];
                int newM = p.y + dm[i];

                if (newN < 0 || newM < 0 || visit.length <= newN || visit[0].length <= newM) {
                    continue;
                }

                if (rgb[point.x][point.y] == rgb[newN][newM] && !visit[newN][newM]) {
                    queue.add(new Point(newN, newM));
                    visit[newN][newM] = true;
                }
            }
        }

    }

    public static void bfs2(Point point) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(point);
        visit2[point.x][point.y] = true;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newN = p.x + dn[i];
                int newM = p.y + dm[i];

                if (newN < 0 || newM < 0 || visit.length <= newN || visit[0].length <= newM) {
                    continue;
                }

                if (rgb2[point.x][point.y] == rgb2[newN][newM] && !visit2[newN][newM]) {
                    queue.add(new Point(newN, newM));
                    visit2[newN][newM] = true;
                }
            }
        }

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