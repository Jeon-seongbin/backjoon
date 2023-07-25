package com.programmers.level2;

public class DivideNumberCard {
    public static void main(String[] args) {

    }

    public static int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        int a = arrayA[0];
        int b = arrayB[0];

        for (int i = 1; i < arrayA.length; i++) {
            a = gcd(a, arrayA[i]);
            b = gcd(b, arrayB[i]);
        }

        if (isDivided(arrayA, b)) {
            if (answer < b) {
                answer = b;
            }
        }

        if (isDivided(arrayB, a)) {
            if (answer < a) {
                answer = a;
            }
        }

        return answer;
    }

    public static int gcd(int n, int m) {
        int r;
        while (0 < m) {
            r = n % m;
            n = m;
            m = r;
        }
        return n;
    }

    static boolean isDivided(int[] arrays, int target) {
        for (int array : arrays) {
            if (array % target == 0) {
                return false;
            }
        }
        return true;
    }
}
