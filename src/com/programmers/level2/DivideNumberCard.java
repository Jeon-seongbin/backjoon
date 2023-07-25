package com.programmers.level2;

public class DivideNumberCard {
    public static void main(String[] args) {

    }

    public static int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        int arrayAGcd = arrayA[0];
        int arrayBGcd = arrayB[0];
        for (int i = 1; i < arrayA.length; i++) {
            arrayAGcd = gcd(arrayAGcd, arrayA[i]);
            arrayBGcd = gcd(arrayBGcd, arrayB[i]);
        }

        if (!isDevided(arrayA, arrayBGcd)) {
            if (answer < arrayBGcd) {
                answer = arrayBGcd;
            }
        }

        if (!isDevided(arrayB, arrayAGcd)) {
            if (answer < arrayAGcd) {
                answer = arrayAGcd;
            }
        }
        return answer;
    }

    public static boolean isDevided(int[] array, int gcd) {
        for (int a : array) {
            if (a % gcd == 0) {
                return true;
            }
        }
        return false;
    }

    public static int gcd(int n, int m) {
        int r;
        while (m > 0) {
            r = n % m;
            n = m;
            m = r;
        }
        return n;
    }
}
