package com.acmicpc.company12;

import java.io.*;
import java.util.*;

public class Main4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 큐의 크기 N
        int n = Integer.parseInt(st.nextToken());

        //뽑아내려고 하는 수의 개수 M
        int m = Integer.parseInt(st.nextToken());

        //뽑아내려고 하는 수 입력 큐에 삽입
        Deque<Integer> deque = new ArrayDeque<Integer>();
        Deque<Integer> checkLeftDeque = new ArrayDeque<Integer>();
        Deque<Integer> checkRightDeque = new ArrayDeque<Integer>();


        for (int i = 1; i <= n; i++) {
            deque.offerFirst(i);
            checkLeftDeque.offerFirst(i);
            checkRightDeque.offerFirst(i);
        }

        // 뽑아 낼려고 하는 수 입력 후 저장
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 결과
        int result = 0;

        for (int i = 0; i < m; i++) {
            //뽑아낼려고 하는 수 확인
            int number = arr[i];

            //만약에 찾는 수가 처음에 있다면 뽑아냄
            // 카운트는 올리지 않음
            if (deque.peekLast() == number) {
                deque.pollLast();
                checkLeftDeque.pollLast();
                checkRightDeque.pollLast();

                continue;
            }

            // deque가 가까운지 poll이 가까운지 확인할려고 하는 수
            int leftCount = 0;
            int rightCount = 0;


            while (true) {
                int leftNumber = checkLeftDeque.pollFirst();
                leftCount++;
                if (leftNumber == number) {
                    // 이때는 왼쪽 수가 이동을 안하기 떄문에  -1 처리를 안해줌

                    break;
                }
            }

            while (true) { // 2번
                int rightNumber = checkRightDeque.pollLast();
                rightCount++;
                if (rightNumber == number) {
                    rightCount--;
                    break;
                }
            }

            // 어느쪽이 큰지 확인하고 작은값 저장
            if (rightCount <= leftCount) {
                result += rightCount;
            } else {
                result += leftCount;
            }


            // 그 숫자가 나올떄까지 큐를 돌리면서 작업 실시
            while (true) {
                if (rightCount <= leftCount) {
                    int rightNumber = deque.pollLast();
                    if (rightNumber == number) {
                        break;
                    }
                    deque.offerFirst(rightNumber);
                } else {
                    int leftNumber = deque.pollFirst();
                    if (leftNumber == number) {
                        break;
                    }
                    deque.offerLast(leftNumber);
                }
            }

            // 왼쪽으로 밸 큐,
            // 오른쪽으로 뺄 큐
            // 계산 끝나고 초기화
            checkLeftDeque = new ArrayDeque<Integer>();
            checkRightDeque = new ArrayDeque<Integer>();

            for (Integer integer : deque) {
                checkLeftDeque.offerLast(integer);
                checkRightDeque.offerLast(integer);
            }
        }

        bw.write("" + result);
        bw.flush();
        br.close();
        bw.close();
    }
}
