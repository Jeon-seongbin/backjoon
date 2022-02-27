package com.company19;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3 {
    public static int[] visit = new int[100001];
    public static int count = 0;
    public static int subin = 0;
    public static int dongseng = 0;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        subin = Integer.parseInt(st.nextToken());
        dongseng = Integer.parseInt(st.nextToken());

        bfs();
        bw.write("" + visit[dongseng]);
        bw.flush();
        br.close();
        bw.close();

    }

    public static void bfs() {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(subin);

        while (!queue.isEmpty()) {
            int N = queue.poll();
            if (N == dongseng) {
                break;
            }
            if (N - 1 >= 0 && visit[N - 1] == 0) {
                queue.offer(N - 1);
                visit[N - 1] = visit[N] + 1;
            }
            if (N + 1 <= 100000 && visit[N + 1] == 0) {
                queue.offer(N + 1);
                visit[N + 1] = visit[N] + 1;
            }
            if (N * 2 <= 100000 && visit[N * 2] == 0) {
                queue.offer(N  * 2);
                visit[N * 2] = visit[N] + 1;
            }
        }


    }
}