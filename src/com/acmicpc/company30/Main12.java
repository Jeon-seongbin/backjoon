package com.acmicpc.company30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//양 구출
public class Main12 {
    public static ArrayList<Integer>[] map;
    public static ArrayList<Integer>[] tree;
    public static char[] animalType;
    public static int[] animalCount;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new ArrayList[N + 1];
        tree = new ArrayList[N + 1];
        animalType = new char[N + 1];
        animalCount = new int[N + 1];

        for (int i = 1; i <= N ; i++) {
            map[i] = new ArrayList<>();
            tree[i] = new ArrayList<>();
        }

        for (int i = 2; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // S 100 3
            animalType[i] = st.nextToken().charAt(0);
            animalCount[i] = Integer.parseInt(st.nextToken());
            int parent = Integer.parseInt(st.nextToken());
            map[parent].add(i);
            map[i].add(parent);
        }

        makeTree();
        System.out.println(count(1));
    }

    public static void makeTree(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        boolean[] isVisited = new boolean[N + 1];
        isVisited[1] = true;
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int next : map[now]){
                if(isVisited[next]){
                    continue;
                }
                isVisited[next] = true;
                tree[now].add(next);
                queue.add(next);
            }
        }
    }

    public static long count(int N){
        long sum = 0;
        for(int i = 0 ; i < tree[N].size(); i++){
            int next = tree[N].get(i);
           sum += count(next);
        }

        if(animalType[N] == 'S'){
            return sum += animalCount[N];
        }else{
            return Math.max(0, sum - animalCount[N]);
        }
    }
}
