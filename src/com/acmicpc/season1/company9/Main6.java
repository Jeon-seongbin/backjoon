package com.acmicpc.season1.company9;

import java.io.*;
import java.util.ArrayList;

public class Main6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        MinimumHeap heap = new MinimumHeap();

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
        bw.close();
        br.close();
    }
}

class MinimumHeap {
    MinimumHeap() {
        heap = new ArrayList<>();
        heap.add(0);
    }

    private ArrayList<Integer> heap;

    public void insert(int val) {
        heap.add(val);
        int currentPoint = heap.size() - 1;

        while (1 < currentPoint && heap.get(currentPoint) < heap.get(currentPoint / 2)) {
            int temp = heap.get(currentPoint);

            heap.set(currentPoint, heap.get(currentPoint / 2));

            heap.set(currentPoint / 2, temp);

            currentPoint = currentPoint / 2;
        }
    }

    public int delete() {
        if (heap.size() - 1 < 1) {
            return 0;
        }

        int deleteItem = heap.get(1);


        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);


        int currentPoint = 1;

        while (currentPoint * 2 < heap.size()) {

            int min = heap.get(currentPoint * 2);
            int minPos = currentPoint * 2;

            // 만약에 오른쪽 값( 현재 포인트 * 2 + 1) 이 왼쪽 값( 현재 포인트 * 2) 보다 작다면
            // 기준값은 오른쪽이 된다
            if (currentPoint * 2 + 1 < heap.size() && min > heap.get(currentPoint * 2 + 1)) {
                min = heap.get(currentPoint * 2 + 1);
                minPos = currentPoint * 2 + 1;
            }


            if (heap.get(currentPoint) < min) {
                break;
            }


            int temp = heap.get(currentPoint);
            heap.set(currentPoint, heap.get(minPos));
            heap.set(minPos, temp);
            currentPoint = minPos;

        }

        return deleteItem;
    }

}