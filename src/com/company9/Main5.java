package com.company9;

import java.io.*;
import java.util.ArrayList;

// https://www.acmicpc.net/problem/11279
public class Main5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        MaximumHeap heap = new MaximumHeap();

        for (int i = 0; i < count; i++) {

            int userInput = Integer.parseInt(br.readLine());
            if (userInput == 0) {
                int result = heap.delete();
                bw.write("" + result + "\n");
            } else {
                heap.insert(userInput);
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}

class MaximumHeap {
    private ArrayList<Integer> heap;

    public MaximumHeap() {
        heap = new ArrayList<>();
        heap.add(Integer.MAX_VALUE);
    }

    public void insert(int val) {

        heap.add(val);
        int p = heap.size() - 1;

        while (p > 1 && heap.get(p / 2) < heap.get(p)) {

            int temp = heap.get(p / 2);
            heap.set(p / 2, heap.get(p));
            heap.set(p, temp);

            p = p / 2;
        }
    }


    public int delete() {
        if (heap.size() - 1 < 1) {
            return 0;
        }

        int deleteItem = heap.get(1);

        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        // 위치를 루트 노드로 설정함
        int pos = 1;

        // while 문의 조건이 맞는지 설정함

        // 자식노드가(pos * 2) heap size보다 작은지를 우선 비교를 한다
        // 왼쪽에 있는 자식노드
        while ((pos * 2) < heap.size()) {
            int max = heap.get(pos * 2);
            int maxPos = pos * 2;

            // 만약에 오른쪽 값이 더 큰 값을 가지고 있다면
            // 기준값이 오른쪽 값이 된다
            if (((pos * 2 + 1) < heap.size()) && max < heap.get(pos * 2 + 1)) {
                max = heap.get(pos * 2 + 1);
                maxPos = pos * 2 + 1;
            }

            if (heap.get(pos) > max) {
                break;
            }

            int temp = heap.get(pos);
            heap.set(pos, heap.get(maxPos));
            heap.set(maxPos, temp);
            pos = maxPos;

        }
        return deleteItem;
    }
}