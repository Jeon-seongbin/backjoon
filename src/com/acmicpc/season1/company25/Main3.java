package com.acmicpc.season1.company25;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3 {
    public static int N, K;
    public static int map[] = new int[500001];
//    public static boolean isVisited[] = new boolean[500001];
    public static int dp[] = new int[500001];

    public static int move[] = {1, -1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //수빈의 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if (N == K) {
            System.out.print(0);
        } else {
            int result = bfs();
            System.out.println(result);
        }

    }

    public static int bfs() {
        Queue<Point17071> q = new LinkedList<>();
        q.add(new Point17071(N, K, 1));
        int count = 0;
        dp[count] = K;
        while (!q.isEmpty()) {
            Point17071 cur = q.poll();
            int now = cur.n;

            dp[cur.count] = dp[cur.count - 1] + cur.count;
            if (dp[cur.count] < 0 || 500001 <= dp[cur.count]) {
                return -1;
            }
            for (int i = 0; i < 3; i++) {
                int next = 0;
                if (i == 2) {
                    next = now * 2;
                } else {
                    next = now + move[i];
                }
                if (next < 0 || 500001 <= next) {
                    continue;
                }
                if (next == dp[cur.count]) {
                    return cur.count;
                }
                if (map[next] != 9) {
                    continue;
                }

                map[next] = map[now] + 1;
                q.add(new Point17071(next, dp[cur.count], cur.count + 1));
            }
        }
        return -1;
    }
}

class Point17071 {
    int n;
    int k;
    int count;

    Point17071(int n, int k, int count) {
        this.n = n;
        this.k = k;
        this.count = count;
    }
}
