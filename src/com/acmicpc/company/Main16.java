package com.acmicpc.company;

import java.util.Scanner;

public class Main16 {

    static int[] aCount;
    static int[] bCount;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int userInput = s.nextInt();


        if(userInput == 1){
            System.out.println("0 1");
            return;
        }else if(userInput == 2){
            System.out.println("1 1");
            return;
        }else if(userInput == 3){
            System.out.println("1 2");
            return;
        }
        aCount = new int[userInput];
        bCount = new int[userInput];

        aCount[0] = 0;
        aCount[1] = 1;
        aCount[2] = 2;

        bCount[0] = 1;
        bCount[1] = 1;
        bCount[2] = 2;

        getAb(userInput - 1);
        System.out.println(aCount[userInput - 1] + " " + bCount[userInput - 1]);
    }

    static void getAb(int userInput) {
        if (2 < userInput) {
            getAb(userInput - 1);
        }
        bCount[userInput] = bCount[userInput - 1] + bCount[userInput - 2];
        aCount[userInput] = aCount[userInput - 1] + aCount[userInput - 2];
    }
}
