package com.acmicpc.company12;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1926
public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 그림 몇줄인지 입력받기
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 배열값 세팅 그림이 1인지 0인지 입력
        // 각 배열에 입력반은 값 저장
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        // 방문했는지 확인
        // 방문함  : true
        // 방문안함: false
        boolean[][] visit = new boolean[n][m];

        // 그림의 갯수
        int count = 0;

        // 영역의 크기
        int area = 0;

        // 영역의 크기 최댓값
        int max = 0;

        // 각 지점을 큐에 담아서 돌림
        // 상하좌우 연결 되어 있는 값을 담는 큐
        Queue<Pair> queue = new LinkedList<>();

        // 상하좌우 확인
        // 순서대로 오른쪽 아래 왼쪽 윗쪽
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
//        1차원배열 2차원 배열
//        1         0
//        0         1
//        -1        0
//        0         -1

        // 값 입력한 것이 1인지 0인지 모두 체크 해야 한다
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 0이거나 방문한적이 있으면 생략.
                if (arr[i][j] == 0 || visit[i][j]) {
                    continue;
                }

                // 그림이 1 이고 주변에 1이 있는지 없는지 확인 하기 위해 큐에 삽입한다ㄴ
                queue.offer(new Pair(i, j));   // 큐에 좌표를 넣어준다.

                // 방문처리
                visit[i][j] = true;

                // 그림의 갯수 1개 추가
                // 처음으로 그림 1이 보여지는 부분이기 떄문
                count++;

                // 영역의 크기는 0으로 초기화 한다
                // 처음으로 그림 1이 보여지는 부분이기 떄문
                area = 0;

                // 큐가 빌 때까지 돌리는데
                // 즉 상하좌우가 있다고 보는 뜻
                while (!queue.isEmpty()) {

                    // 영역의 크기 +1
                    // 큐가 루프문을 계속 돌릴 땐 그림이 연결되어있다는것
                    area++;

                    //큐를 뽑아낸다
                    Pair p = queue.poll();

                    // 순서대로 오른쪽 아래 왼쪽 윗쪽 체크
                    for (int checkDXDY = 0; checkDXDY < 4; checkDXDY++) {
                        int newX = p.getX() + dx[checkDXDY];
//                                    1           1
                        int newY = p.getY() + dy[checkDXDY];
//                                    1           1
//                        세로 구한 좌표

                        if (newX < 0 || newY < 0 || n <= newX || m <= newY) {
                            // 좌표 값 보다 이상이면 넘어간다
                            // 지정한 좌표 값이 0보다 작을때
                            // 지정한 좌표 값이 4이고 새로 구한 좌표가 5일때 -> 범위가 넘어갈때
                            continue;
                        }

                        // 그림에서 새로 구한 좌표의 값이 1이고 방문하지 않았을때
                        if (arr[newX][newY] == 1 && !visit[newX][newY]) {
                            // 기존에 있는 큐에서 큐를 더한다
                            queue.offer(new Pair(newX, newY));

                            // 새로운 좌표에 true입력
                            visit[newX][newY] = true;
                        }
                    }
                }

                // 큐가 끝났을때 -> 연결된 그림이 없을때
                // 최대 영역 수 구함
                if (area > max) {
                    max = area;
                }
            }
        }
        bw.write("" + count + "\n");
        bw.write("" + max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}

// 상하좌우 지점을 저장할 클래스
class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}