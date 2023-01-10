package com.acmicpc.season1.company17;
import java.util.Scanner;

public class Main7 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long userInput = s.nextInt();

        long[] cases = new long[1000001];
        cases[0] = 0;
        cases[1] = 1;
        cases[2] = 2;
        cases[3] = 4;

        for (int i = 0; i < userInput; i++) {
            int u = s.nextInt();
            for (int j = 4; j <= u; j++) {
                cases[j] = (cases[j - 1] + cases[j - 2] + cases[j - 3]) %1000000009;
            }
            System.out.println(cases[u]);
        }
    }
}
