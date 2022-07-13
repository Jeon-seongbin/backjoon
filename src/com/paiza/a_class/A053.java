package com.paiza.a_class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A053 {
    public static int x, y;
    public static char[][] map;
    public static boolean[][] isVisited;

    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = 0, g = 0, b = 0;
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        map = new char[x][y];
        isVisited = new boolean[x][y];

        for (int i = 0; i < x; i++) {
            String input = br.readLine();
            for (int j = 0; j < y; j++) {
                map[i][j] = input.charAt(j);
            }
        }


        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (isVisited[i][j] || map[i][j] != 'R') {
                    continue;
                }
                r += bfs(i, j, 'R');
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (isVisited[i][j] || map[i][j] != 'G') {
                    continue;
                }
                g += bfs(i, j, 'G');
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (isVisited[i][j] || map[i][j] != 'B') {
                    continue;
                }
                b += bfs(i, j, 'B');
            }
        }

        System.out.println(r + " " + g + " " + b);
    }

    public static int bfs(int xx, int yy, char rgb) {


        Queue<PointA053> queue = new LinkedList<>();

        queue.add(new PointA053(xx, yy));
        isVisited[xx][yy] = true;
        int result = 1;

        while (!queue.isEmpty()) {

            PointA053 now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newX = now.x + dx[i];
                int newY = now.y + dy[i];

                if (newX < 0 || x <= newX || newY < 0 || y <= newY) {
                    continue;
                }
                if (isVisited[newX][newY]) {
                    continue;
                }

                if (map[newX][newY] != rgb) {
                    continue;
                }
                queue.add(new PointA053(newX, newY));
                isVisited[newX][newY] = true;
            }
        }

        return result;
    }
}

class PointA053 {
    int x;
    int y;

    public PointA053(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
