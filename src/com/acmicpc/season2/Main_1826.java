package com.acmicpc.season2;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1826 {
    public static Queue<int[]> q;
    public static Queue<Integer> fuelQ;
    public static int town;
    public static int curFuel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        q = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]); // 거리순 heap
        fuelQ = new PriorityQueue<>(Collections.reverseOrder());
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dist = Integer.parseInt(st.nextToken());
            int pointFuel = Integer.parseInt(st.nextToken());
            int[] c = new int[]{dist, pointFuel};
            q.add(c);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        town = Integer.parseInt(st.nextToken());
        curFuel = Integer.parseInt(st.nextToken());

        System.out.println(getCount());
    }

    public static int getCount() {
        int result = 0;
        while (curFuel < town) {
            while (!q.isEmpty() && q.peek()[0] <= curFuel) {
                fuelQ.add(q.poll()[1]);
            }

            if (fuelQ.isEmpty()) {
                return -1;
            }

            result++;
            curFuel += fuelQ.poll();
        }
        return result;
    }

}

