package com.company13;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            queue.offer(Integer.parseInt(br.readLine()));
            ArrayList<Integer> arrayList = new ArrayList<>();
            int mid = queue.size() / 2;
            int peek = mid;
            if (i == 1 || i == 2) {
                peek = queue.peek();
                bw.write("" + peek + "\n");
                continue;
            }

            if (i % 2 != 0) {

                // 홀 수
                peek = mid + 1;
            }

            for (int j = 0; j < peek - 1; j++) {
                arrayList.add(queue.poll());
            }
            peek = queue.peek();
            bw.write("" + peek + "\n");

            for (Integer integer : arrayList) {
                queue.add(integer);
            }

        }

        bw.flush();
        br.close();
        bw.close();
    }
}
