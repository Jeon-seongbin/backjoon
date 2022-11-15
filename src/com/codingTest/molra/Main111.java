package com.codingTest.molra;

import java.io.*;
import java.util.*;
/*
어두운방
스위치 구성이
1,1 번 방 - > 1,2 1,3
1,2 번 방 -> 2,2 2,3
3, 3 번 방 -> 5,5
5,5 번 방 -> 1 3, 2 4

이런식으로 되어있는데

스위치 불 키면서 방 옆으로 옮길수있고
방이 어두워서 진행 못하면 그대로 끝

불 켠 방 몇개?

 */
/*
5 25
5 3 4 3
1 1 1 3
1 3 2 2
4 2 4 3
1 1 1 2
1 4 3 5
5 1 3 1
5 3 5 2
4 3 4 5
5 4 3 1
5 4 3 4
3 4 5 4
3 3 4 3
3 3 1 5
1 2 2 1
4 5 3 1
1 4 3 3
4 5 1 3
2 1 5 1
3 5 5 1
2 1 1 4
4 3 5 4
1 3 2 3
3 3 5 2
1 2 3 1

16

5 10
3 5 1 2
1 1 1 2
1 1 2 2
3 3 1 1
4 1 3 2
1 2 1 3
2 3 4 3
1 1 2 1
5 1 2 1
1 1 3 2

6

5 7
1 1 1 2
1 1 3 3
3 3 5 5
1 2 2 2
1 2 2 3
5 5 1 3
5 5 2 4

6
 */
public class Main111 {

    public static int N = 0;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static ArrayList<Point111>[][] map;
    public static boolean[][] canVisit;
    public static boolean[][] isVisited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // initialize
        N = Integer.parseInt(st.nextToken());

        N++;

        int inputCount = Integer.parseInt(st.nextToken());
        map = new ArrayList[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        canVisit = new boolean[N][N];
        isVisited = new boolean[N][N];

        HashSet<String> answerdata = new HashSet<>();
        answerdata.add(1 + ":" + 1);
        // input
        for (int i = 0; i < inputCount; i++) {
            st = new StringTokenizer(br.readLine());
            int ii = Integer.parseInt(st.nextToken());
            int jj = Integer.parseInt(st.nextToken());
            int nextii = Integer.parseInt(st.nextToken());
            int nextjj = Integer.parseInt(st.nextToken());
            map[ii][jj].add(new Point111(ii, jj, nextii, nextjj));
        }


        Queue<Location111> q = new LinkedList<>();
        q.add(new Location111(1, 1));
        canVisit[1][1] = true;

        while (!q.isEmpty()) {
            Location111 now = q.poll();
            isVisited[now.x][now.y] = true;
            ArrayList<Point111> nowPoint = map[now.x][now.y];

            for (int i = 0; i < nowPoint.size(); i++) {
                Point111 nowPoint111 = nowPoint.get(i);
                // 갈 수 있는 곳 체크 하기
                // 스위치로 불 켜기
                canVisit[nowPoint111.nextX][nowPoint111.nextY] = true;

                if (// 간선이 몇개씩 나올 수 있으니 일단 방문 처리 해놓고
                    // 스위치로 불 켜서
                    // 이제 갈 수 있게 된 위치의 상하좌우에
                    // 과거에 이미 방문한 적이 있으면
                    // 바로 갈 수 있다고 판단하고 add
                        (nowPoint111.nextX + 1 < N && isVisited[nowPoint111.nextX + 1][nowPoint111.nextY]) ||
                                (nowPoint111.nextX - 1 > 0 && isVisited[nowPoint111.nextX - 1][nowPoint111.nextY]) ||
                                (nowPoint111.nextY + 1 < N && isVisited[nowPoint111.nextX][nowPoint111.nextY + 1]) ||
                                (nowPoint111.nextY - 1 > 0 && isVisited[nowPoint111.nextX][nowPoint111.nextY - 1])) {
                    q.add(new Location111(nowPoint111.nextX, nowPoint111.nextY));
                }

                // 해시셋으로 중복 제거(간 곳 처리)
                answerdata.add(nowPoint111.nextX + ":" + nowPoint111.nextY);
            }

            // 갈 곳이며 안 간 곳인데 상하좌우만 움직일 것.
            // 동
            if (now.x + 1 < N && !isVisited[now.x + 1][now.y] && canVisit[now.x + 1][now.y]) {
                // System.out.println(x + " : " + y + " -> " + (x+1) + " : "
                // + y
                // + " " + tmp);
                q.add(new Location111(now.x + 1, now.y));
            }

            // 서
            if (now.x - 1 > 0 && !isVisited[now.x - 1][now.y] && canVisit[now.x - 1][now.y]) {
                // System.out.println(x + " : " + y + " -> " + (x-1) + " : "
                // +
                // y+ " " + tmp);
                q.add(new Location111(now.x - 1, now.y));
            }

            // 남
            if (now.y + 1 < N && !isVisited[now.x][now.y + 1] && canVisit[now.x][now.y + 1]) {
                // System.out.println(x + " : " + y + " -> " + (x) + " : " +
                // (y+1)+ " " + tmp);
                q.add(new Location111(now.x, now.y + 1));
            }
            // 북
            if (now.y - 1 > 0 && !isVisited[now.x][now.y - 1] && canVisit[now.x][now.y - 1]) {
                // System.out.println(x + " : " + y + " -> " + (x) + " : " +
                // (y-1)+ " " + tmp);
                q.add(new Location111(now.x, now.y - 1));
            }
        }


        bw.write("" + answerdata.size());
        bw.flush();
        bw.close();
        br.close();

    }
}

class Point111 {
    int nowX;
    int nowY;
    int nextX;
    int nextY;


    Point111(int nowX, int nowY, int nextX, int nextY) {
        this.nowX = nowX;
        this.nowY = nowY;

        this.nextX = nextX;
        this.nextY = nextY;

    }
}

class Location111 {
    int x;
    int y;

    public Location111(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }
}