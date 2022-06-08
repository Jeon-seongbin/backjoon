package com.acmicpc.company28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
    public static int gondolaCount;
    public static int groupCount;

    public static int allPeople;

    // 곤돌라 자체
    public static ArrayList<GondolaB108> gondola = new ArrayList<>();

    // 곤돌라 기능을 함
    public static Queue<GondolaB108> queue = new LinkedList<>();

    public static ArrayList<Integer> group = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        gondolaCount = Integer.parseInt(st.nextToken());
        groupCount = Integer.parseInt(st.nextToken());

        for (int i = 0; i < gondolaCount; i++) {
            st = new StringTokenizer(br.readLine());
            GondolaB108 g = new GondolaB108(Integer.parseInt(st.nextToken()), 0);
            gondola.add(g);
            queue.offer(g);
        }
        for (int i = 0; i < groupCount; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            allPeople += a;
            group.add(a);
        }

        int nosetaHito = 0;

        int i = 0;
        while (true) {
            if (nosetaHito == allPeople) {
                break;
            }

            GondolaB108 nowGondola = queue.poll();

            assert nowGondola != null;

            int nowGroupNinzu = group.get(i);
            if (nowGroupNinzu <= nowGondola.kigenPeople) {
                nowGondola.haixtuteiruPeople += nowGroupNinzu;
                nosetaHito += nowGroupNinzu;
                group.set(i, 0);
                i++;
            } else {
                nowGondola.haixtuteiruPeople += nowGondola.kigenPeople;
                nosetaHito += nowGondola.kigenPeople;
                group.set(i, nowGroupNinzu - nowGondola.kigenPeople);
            }
            queue.add(nowGondola);
        }

        for (GondolaB108 now1 : gondola) {
            System.out.println(now1.haixtuteiruPeople);
        }
    }
}

class GondolaB108 {
    int kigenPeople;
    int haixtuteiruPeople;

    GondolaB108(int kigenPeople, int haixtuteiruPeople) {
        this.kigenPeople = kigenPeople;
        this.haixtuteiruPeople = haixtuteiruPeople;
    }
}