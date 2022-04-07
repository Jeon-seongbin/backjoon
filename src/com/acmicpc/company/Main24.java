package com.acmicpc.company;

import java.io.IOException;
import java.util.Scanner;

public class Main24 {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int userInput = Integer.parseInt(s.nextLine());
        if(userInput == 1){
            System.out.println("*");
            return;
        }

        for(int i = 0 ; i < userInput ; i++){
            for(int j = 0 ; j < userInput ; j++){
                if(i % 2 == 0){
                    System.out.print("* ");
                }else{
                    System.out.print(" *");
                }
            }
            System.out.println();
        }
    }
}