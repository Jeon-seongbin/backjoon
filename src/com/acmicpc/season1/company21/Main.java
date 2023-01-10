package com.acmicpc.season1.company21;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1202
public class Main {

    public static Jewel[] jewels;
    public static int[] begs;

    public static void main(String[] args) throws IOException {
        // 보석의 최대 가격
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 첫째 줄에 N과 K가 주어진다. (1 ≤ N, K ≤ 300,000)
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long price = 0;
        jewels = new Jewel[N];
        begs = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            jewels[i] = new Jewel(m, v);
            // 무계 m
            // 가격 v
        }

        // 보석을 무계 오름차순으로 정렬
        // 보석 리스트를 무게 오름차순으로 정렬
        Arrays.sort(jewels, new Comparator<Jewel>() {
            @Override
            public int compare(Jewel o1, Jewel o2) {
                return o1.m - o2.m;
            }
        });

        // 가방 오름차순으로 정렬
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            begs[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(begs);

        // 우선순위 큐 - 가치 내림차순으로
        PriorityQueue<Jewel> pq = new PriorityQueue<>((o1, o2) -> o2.v - o1.v);

        int idx = 0;
        for (int i = 0; i < K; i++) {
            while (idx < N && jewels[idx].m <= begs[i]) {
                pq.add(jewels[idx]);
                idx++;
            }

            if (!pq.isEmpty()) {
                price += pq.poll().v;
            }
        }


        bw.write("" + price);
        bw.flush();
        br.close();
        bw.close();
    }
}

class Jewel {
    int m;
    int v;

    Jewel(int m, int v) {
        this.m = m;
        this.v = v;
    }
}