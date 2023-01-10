package com.acmicpc.season1.company24;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3 {
    public static boolean[] isVisited;
    public static ArrayList<ArrayList<Integer>> arrayList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = 0;
        while (true) {
            testCase++;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            // 는 정점의 개수 n과 간선의 개수 m이 주어진다. 다음 m개의 줄에는 간선을 나타내는 두 개의 정수가 주어진다. 같은 간선은 여러 번 주어지지 않는다.
            if (n == 0 && m == 0) {
                break;
            }

            n++;
            arrayList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arrayList.add(new ArrayList<>());
            }
            isVisited = new boolean[n];


            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arrayList.get(a).add(b);
                arrayList.get(b).add(a);
            }

            int count = 0;


            for (int i = 1; i < n; i++) {
                if (isVisited[i]) {
                    continue;
                }
                int nodeCount = 0;
                int edgeCount = 0;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                isVisited[i] = true;

                while (!queue.isEmpty()) {
                    nodeCount++;
                    int now = queue.poll();
                    for (int j = 0; j < arrayList.get(now).size(); j++) {
                        int next = arrayList.get(now).get(j);
                        edgeCount++;
                        if (isVisited[next]) {
                            continue;
                        }
                        isVisited[next] = true;
                        queue.add(next);

                    }
                }
                if (nodeCount == (edgeCount / 2) + 1) {
                    count++;
                }

            }
            String answer = "Case " + testCase + ":";
            if (count == 1) {
                answer = answer + " There is one tree.\n";

            } else if (1 < count) {
                answer = answer + " A forest of " + count + " trees.\n";

            } else {
                answer = answer + " No trees.\n";
            }
            bw.write(answer);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
