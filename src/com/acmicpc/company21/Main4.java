package com.acmicpc.company21;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main4 {

    public static int userInput = 0;
    public static int size = 2;
    public static int firstX;
    public static int firstY;
    public static int time;
    public static int count;
    public static int[][] map;
    public static boolean[][] isVisited;

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static Queue<Info> queue;
    public static ArrayList<Info> arrayList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        userInput = Integer.parseInt(st.nextToken());
        queue = new LinkedList<>();

        map = new int[userInput][userInput];
        isVisited = new boolean[userInput][userInput];
        for (int i = 0; i < userInput; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < userInput; j++) {
                int temp = Integer.parseInt(st.nextToken());
                map[i][j] = temp;
                if (temp == 9) {
                    map[i][j] = 0;
                    firstX = i;
                    firstY = j;

                }
            }
        }

        bfs();

    }

    public static void bfs() {
        while (true) {

            // 왜 이걸 while문 안에?

            //먹이 리스트
            arrayList = new ArrayList<Info>();
            isVisited = new boolean[userInput][userInput];
            queue.add(new Info(firstX, firstY, 0));
            isVisited[firstX][firstY] = true;

            while (!queue.isEmpty()) {
                Info shark = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int newX = shark.x + dx[i];
                    int newY = shark.y + dy[i];

                    // 범위 체크
                    if (newX < 0 || userInput <= newX || newY < 0 || userInput <= newY) {
                        continue;
                    }
                    // 방문 체크
                    if (isVisited[newX][newY]) {
                        continue;
                    }

                    // 먹이를 찾은 경우
                    // (0보다 크고 상어의 사이즈보다 작은 경우만 먹을 수 있다는 조건)
                    if (1 <= map[newX][newY] && map[newX][newY] < size) {

                        //상어의 위치 갱신
                        queue.add(new Info(newX, newY, shark.dist + 1));

                        // 먹이 리스트에 삽입
                        arrayList.add(new Info(newX, newY, shark.dist + 1));

                        // 방문 했다고 표시
                        isVisited[newX][newY] = true;

                    } else if (map[newX][newY] == size || map[newX][newY] == 0) {
                        // 먹을 수는 있지만 지나갈 수 있는 경우
                        // (0이거나 상어의 사이즈와 같은 경우 지나갈 수 있다는 조건)

                        //상어의 위치 갱신
                        queue.add(new Info(newX, newY, shark.dist + 1));

                        // 방문 했다고 표시
                        isVisited[newX][newY] = true;
                    }
                }
            }

            // 사이즈가 0인 경우 먹을 수 있는 물고기가 없는 경우이므로 출력
            if (arrayList.size() == 0) {
                System.out.println(time);
                return;
            }


            // 먹을 물고기가 있을 경우
            Info eatingFish = arrayList.get(0);

            // 이건 왜 사이즈만큼 돌리지?
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).dist < eatingFish.dist) { // 거리가 최소인 물고기로 갱신
                    eatingFish = arrayList.get(i);
                }

                // 거리가 같은 경우 X가 작은 물고기가 우선순위가 되므로 갱신
                if (eatingFish.dist == arrayList.get(i).dist) {
                    if (eatingFish.x > arrayList.get(i).x) {
                        eatingFish = arrayList.get(i);
                    }
                }
            }
            time += eatingFish.dist; // 먹을 물고기의 거리를 time에 추가
            count++; // 먹었으므로 카운트 증가
            map[eatingFish.x][eatingFish.y] = 0; // 물고기를 먹은 자리 0으로 갱신
            if (count == size) { // 먹은 물고기의 수와 상어의 사이즈가 같은 경우
                size++; // 상어의 사이즈 1 증가
                count = 0; // 다시 카운트는 0으로 초기화
            }
            firstX = eatingFish.x; // 상어의 위치 갱신
            firstY = eatingFish.y; // 상어의 위치 갱신
        }
    }
}

class Info {
    int x, y, dist;

    Info(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
