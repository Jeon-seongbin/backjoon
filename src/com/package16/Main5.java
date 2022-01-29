package com.package16;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main5 {
    static char[][] map;
    static Queue<Position> fq;
    static Queue<Position> q;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int row, col, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int inputCount = Integer.parseInt(st.nextToken());

        for (int c = 0; c < inputCount; c++) {
            st = new StringTokenizer(br.readLine());
            col = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());

            fq = new LinkedList<>();
            q = new LinkedList<>();
            map = new char[row][col];
            ans = 0;
            // input
            for (int i = 0; i < row; i++) {
                char[] input = br.readLine().toCharArray();
                for (int j = 0; j < col; j++) {
                    map[i][j] = input[j];
                    if (map[i][j] == '@') {
                        q.offer(new Position(i, j));
                    }
                    if (map[i][j] == '*') {
                        fq.offer(new Position(i, j));
                    }
                }
            }
            bfs();
            if (ans == 0) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(ans);
            }
        }
        br.close();
    }

    static void bfs() {
        int size = 0;
        while (!q.isEmpty()) {

            size = fq.size();
            for (int i = 0; i < size; i++) {
                Position p = fq.poll();
                for (int k = 0; k < 4; k++) {
                    int nC = p.col + dx[k];
                    int nR = p.row + dy[k];

                    if (nC < 0 || nR < 0 || col <= nC || row <= nR) {
                        continue;
                    }
                    if (map[nR][nC] == '.' || map[nR][nC] == '@') {
                        map[nR][nC] = '*';
                        fq.add(new Position(nR, nC));
                    }
//                    if (map[nR][nC] == '*' || map[nR][nC] == '@' || map[nR][nC] == '#') {
//                        continue;
//                    }
//                    map[nR][nC] = '*';
//                    fq.offer(new Position(nR, nC));
                }
            }

            size = q.size();

            for (int i = 0; i < size; i++) {
                Position p = q.poll();
                for (int k = 0; k < 4; k++) {
                    int nC = p.col + dx[k];
                    int nR = p.row + dy[k];

                    if (nC < 0 || nR < 0 || col <= nC || row <= nR) {
                        ans = p.cnt + 1;
                        return;
                    }
                    if (map[nR][nC] == '.') {
                        map[nR][nC] = '@';
                        q.add(new Position(nR, nC, p.cnt + 1));
                    }
//                    if (map[nR][nC] == '*' || map[nR][nC] == '@' || map[nR][nC] == '#') {
//                        continue;
//                    }
//                    q.offer(new Position(nR, nC, p.cnt + 1));

                }
            }
        }
    }
}

class Position {
    int row, col, cnt;

    Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    Position(int row, int col, int cnt) {
        this.row = row;
        this.col = col;
        this.cnt = cnt;
    }
}