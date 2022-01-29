package com.company14;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        //예를들어 최소힙에는  순서대로 9, 10   최대힙은 3, 2, 1 이라면 가운데 숫자는 3이 됩니다.
        //이렇게 최소힙 ~ 최대힙의 순열을 유지하기 위해 최소힙의 최솟값이 최대힙의 최댓값보다  항상 크게 유지시켜줘야 합니다.
        //그래서 안그런경우 최소힙의 최솟값과 최대힙의 최댓값을 SWAP 해주어 순열을 유지할 수 있도록 해주는겁니다.

        for (int i = 0; i < n; i++) {
            int userInput = Integer.parseInt(br.readLine());
            if (maxHeap.size() == minHeap.size()) {
                maxHeap.add(userInput);
            } else {
                minHeap.add(userInput);
            }

            if (!minHeap.isEmpty() && !maxHeap.isEmpty()) {
                if (minHeap.peek() < maxHeap.peek()) {
                    int temp = minHeap.poll();
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(temp);
                }
            }
            bw.write("" + maxHeap.peek()+"\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
