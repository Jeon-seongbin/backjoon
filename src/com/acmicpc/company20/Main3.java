package com.acmicpc.company20;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3 {

    public static int resultCount = 0;
    public static boolean[][] visited;

    public static Queue<Point3> queue = new LinkedList<>();

    public static int col = 0;
    public static int row = 0;
    public static int mapSize = 0;

    public static int endCol = 0;
    public static int endRow = 0;

    public static int dx[] = {-2, -1, 1, 2, -2, -1, 1, 2};
    public static int dy[] = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(st.nextToken());

        for (int c = 0; c < count; c++) {
            st = new StringTokenizer(br.readLine());
            mapSize = Integer.parseInt(st.nextToken());
            visited = new boolean[mapSize][mapSize];
            st = new StringTokenizer(br.readLine());
            col = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            endCol = Integer.parseInt(st.nextToken());
            endRow = Integer.parseInt(st.nextToken());
            bfs();
            bw.write("" + (resultCount) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }

    public static void bfs() {
        Point3 pp = new Point3(col, row, 0);
        Point3 pEnd = new Point3(endCol,endRow , 0);
        // 왜 이렇게 해줘야하지??

        Queue<Point3> queue = new LinkedList<>();
        queue.add(pp);

        while (!queue.isEmpty()) {
            Point3 p = queue.poll();

            if (p.x == pEnd.x && p.y == pEnd.y) {
                resultCount = p.count;
                break;
            }

            for (int i = 0; i < 8; i++) {
                int newX = p.x + dx[i];
                int newY = p.y + dy[i];
                int currentCount = p.count;

                // 범위 안
                if (!(0 <= newX && newX < mapSize && 0 <= newY && newY < mapSize)) {
                    continue;
                }
                if (visited[newX][newY]) {
                    continue;
                }
                Point3 newP = new Point3(newX, newY, currentCount + 1);
                visited[newX][newY] = true;
                queue.add(newP);
            }
        }
    }
}

class Point3 {
    int x;
    int y;
    int count;

    Point3(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}