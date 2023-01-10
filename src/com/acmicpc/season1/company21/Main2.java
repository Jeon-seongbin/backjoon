package com.acmicpc.season1.company21;

import java.io.*;
import java.util.*;

public class Main2 {
    public static int N;
    public static int M;

    /**
     * K 난이도
     * V 문제들
     */
    public static TreeMap<Integer, ArrayList<Integer>> treeMap = new TreeMap<>();

    /**
     * K 문제
     * V 난이도
     */
    public static HashMap<Integer, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            // 문제 번호 P와 난이도 L가 공백
            int bango = Integer.parseInt(st.nextToken());
            int nanido = Integer.parseInt(st.nextToken());

            if (treeMap.containsKey(nanido)) {
                ArrayList<Integer> a = treeMap.get(nanido);
                a.add(bango);
                Collections.sort(a);
                treeMap.put(nanido, a);
            } else {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(bango);
                treeMap.put(nanido, arrayList);
            }
            hashMap.put(bango, nanido);
        }
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();

            if (operation.equals("add")) {
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                add(p, l);
            } else if (operation.equals("recommend")) {
                int x = Integer.parseInt(st.nextToken());
                int result = recommand(x);
                bw.write("" + result + "\n");
            } else {
                // solved
                int sp = Integer.parseInt(st.nextToken());
                solve(sp);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 추천 문제 리스트에 난이도가 L인 문제 번호 P를 추가한다
     *
     * @param P 문제번호
     * @param L 난이도
     */
    public static void add(int P, int L) {
        if (treeMap.containsKey(L)) {
            ArrayList<Integer> a = treeMap.get(L);
            a.add(P);
            Collections.sort(a);
            treeMap.put(L, a);
        } else {
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(P);
            treeMap.put(L, arrayList);
        }
        hashMap.put(P, L);
    }

    /**
     * 추천 문제 리스트에서 문제 번호 P를 제거한다.
     *
     * @param P 문제번호
     */
    public static void solve(int P) {
        int naido = hashMap.get(P);
        ArrayList<Integer> arrayList = treeMap.get(naido);

        hashMap.remove(P);
        int size = arrayList.size();
        int i = 0;
        for (; i < size; i++) {
            if (arrayList.get(i) == P) {
                break;
            }
        }
        arrayList.remove(i);

        if (arrayList.size() == 0) {
            treeMap.remove(naido);
        } else {
            treeMap.put(naido, arrayList);

        }

    }

    /**
     * x가 1인 경우 추천 문제 리스트에서 가장 어려운 문제의 번호를 출력한다.
     * 만약 가장 어려운 문제가 여러 개라면 문제 번호가 큰 것으로 출력한다.
     * x가 -1인 경우 추천 문제 리스트에서 가장 쉬운 문제의 번호를 출력한다.
     * 만약 가장 쉬운 문제가 여러 개라면 문제 번호가 작은 것으로 출력한다.
     *
     * @param x x가 1인 경우 x가 -1인 경우
     * @return 추천문제
     */
    public static int recommand(int x) {
        int naido = 0;
        ArrayList<Integer> arrayList;
        int result = 0;
        if (x == 1) {
            naido = treeMap.lastKey();
            arrayList = treeMap.get(naido);
            result = arrayList.get(arrayList.size() -1);
        } else {
            naido = treeMap.firstKey();
            arrayList = treeMap.get(naido);
            result = arrayList.get(0);
        }
        return result;
    }
}
