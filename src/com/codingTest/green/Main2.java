package com.codingTest.green;

import java.util.Arrays;

/*
정수로 구성된 리스트로부터 3개의 수를 선택해서 곱셈을 행한후
그 수가 최대가 되는 수를 출력하는 프로그래밍을 코딩하세요
입력은 정수가 , 구분으로 넘겨집니다
리스트의 요소가 3개를 넘지 않을 경우 -1을 출력하세요

소팅하고
앞에 두개
뒤에하나

뒤에 두개
앞에 하나

비교
 */
public class Main2 {
    public static void main(String[] args) {
        int[] arr = {-1323, -127, 6, 45, 21, 9, 101, 102};


        System.out.println(new Main2().solution(arr));
    }

    public int solution(int[] A) {
        if (A.length <= 3) {
            return -1;
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) {
                A[i] = -1 * A[i];
            }
        }

        Arrays.sort(A);

        int a = A[A.length - 1];

        int b = A[A.length - 2];

        int c = A[A.length - 3];

        return a * b * c;

    }
}
