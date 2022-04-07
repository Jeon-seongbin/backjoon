package com.acmicpc.company;

import java.util.Scanner;

public class Main20 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[][] userInput = new int[9][9];

        for (int i = 0; i < 9; i++) {
            String arg = s.nextLine();
            String[] a = arg.split(" ");
            for (int j = 0; j < 9; j++) {
                userInput[i][j] = Integer.parseInt(a[j]);
            }
        }

        int bigI = 0;
        int bigJ = 0;
        int big = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                int compare = userInput[i - 1][j - 1];
                if (big < compare) {
                    big = compare;
                    bigI = i;
                    bigJ = j;
                }
            }
        }

        System.out.println(big);
        System.out.println(bigI + " " + bigJ);

    }
}
