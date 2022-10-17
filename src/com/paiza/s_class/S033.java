package com.paiza.s_class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 플레이어 1이 빠져나갈수있는 가장 최소 수
// 플레이어 2는 그냥 길막용

public class S033 {

    public static int[] dx = new int[]{1, 0, -1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};
    public static int W, H;
    public static char[][] map;
    public static boolean[][] isVisited;

    public static Queue<PointS033> point1;
//    public static Queue<PointS033> point2;
//

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new char[H][W];
        isVisited = new boolean[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();

            for (int j = 0; j < W; j++) {
                char tempChar = temp.charAt(j);
                map[i][j] = tempChar;
                if (tempChar == '1') {
                    point1 = new LinkedList<>();
                    point1.add(new PointS033(i, j, 0));
                    isVisited[i][j] = true;
                }

                if (tempChar == '2') {
                    isVisited[i][j] = true;
                }

                if (tempChar == '#') {
                    isVisited[i][j] = true;
                }
            }
        }

        System.out.println(bfs());

    }

    public static int bfs() {
        int max = 1;
        while (!point1.isEmpty()) {
            PointS033 now = point1.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if (nextX < 0 || H <= nextX || nextY < 0 || W <= nextY) {
                    continue;
                }

                if (isVisited[nextX][nextY] == false && map[nextX][nextY] != '2' && map[nextX][nextY] != '#') {
                    isVisited[nextX][nextY] = true;
                    point1.add(new PointS033(nextX, nextY, now.count + 1));
                    max = Math.max(now.count + 1, max);

                }


            }

        }
        return max;
    }
}

class PointS033 {
    int x;
    int y;
    int count;

    public PointS033(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;

    }
}
        /*
9 8
#####..##
...2#.#.#
###.#..1.
......###
.####.#..
....#####
###.##...
....#..#.
*/