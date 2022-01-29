package com.company12;

import java.io.*;
import java.util.LinkedList;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        LinkedList<Integer> queue = new LinkedList<>();
        StringBuilder builder = new StringBuilder();

        for (int n = 0; n < T; n++) {
            String[] input = reader.readLine().split(" ");
            String[] priority = reader.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            // 몇번째 에서 출력되는지?
            int count = 0;
            queue.clear(); // 큐 초기화

            for (int i = 0; i < N; i++)
                queue.add(Integer.parseInt(priority[i])); // 큐에 중요도 데이터 추가

            while (!queue.isEmpty()) {
                boolean isPriority = true;

                for (int i = 0; i < queue.size(); i++) {// 맨 앞 데이터의 중요도가 가장 높은지 확인
                    if (queue.peek() < queue.get(i)) {
                        // 맨 앞 데이터 < 다음 데이터
                        isPriority = false;
                        break;
                    }
                }
                if (isPriority) {
                    count++;
                    // 하나씩 없에는것이 포인트
                    queue.poll();

                    // 갯수가 0이 될 때 까지 진행
                    if (M == 0) {
                        break;
                    } else {
                        M--;
                    }
                } else {
                    // 맨 앞 데이터의 중요도가 낮을 시
                    // 뒤로 보내는 작업
                    queue.add(queue.poll());

                    // 갯수가 0이 될 때 까지 진행하지만
                    // 뒤로 보낸 경우라 M이 -이 되면 큐 사이즈 만큼 초기화
                    if (M == 0) {
                        M = queue.size() - 1;
                    } else {
                        M--;
                    }
                }


            }
            builder.append(count).append("\n");
        }
        System.out.println(builder);
    }
}