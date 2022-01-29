package com.company6;

import java.util.Arrays;

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
