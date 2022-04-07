package com.acmicpc.package15;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int userInput = s.nextInt();

        int[] cases = new int[11];
        cases[0] = 0;
        cases[1] = 1;
        cases[2] = 2;
        cases[3] = 4;

        for (int i = 0; i < userInput; i++) {
            int u = s.nextInt();
            for (int j = 4; j <= u; j++) {
                cases[j] = cases[j - 1] + cases[j - 2] + cases[j - 3];

            }
            System.out.println(cases[u]);
        }
    }
}
