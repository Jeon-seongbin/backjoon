package com.acmicpc.season1.company;

import java.util.Scanner;

public class Main17 {
    static int[][] temp;
    static int blueCount = 0;
    static int whiteCount = 0;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Scanner z = new Scanner(System.in);
        int userInput = s.nextInt();
        temp = new int[userInput][userInput];

        for (int i = 0; i < userInput; i++) {
            String arg = z.nextLine();
            String[] tempStrArr = arg.split(" ");
            for (int j = 0; j < userInput; j++) {
                int tem = Integer.parseInt(tempStrArr[j]);
                temp[i][j] = tem;
            }
        }

        getColor(userInput, 0, 0);

        System.out.println(whiteCount);
        System.out.println(blueCount);
        s.close();
        z.close();
    }


    static void getColor(int userInput, int xIndex, int yIndex) {


        for(int i = xIndex ; i < xIndex + userInput; i++){
            for(int j = yIndex ; j < yIndex + userInput; j++){
    if(temp[xIndex][yIndex] != temp[i][j]){
        int next = userInput / 2;
        getColor(next, xIndex, yIndex);
        getColor(next , xIndex + next, yIndex);
        getColor(next, xIndex, yIndex + next);
        getColor(next, xIndex + next, yIndex + next);
        return;
    }

            }
        }
       if(temp[xIndex][yIndex] == 0){
           whiteCount++;
       }else{
           blueCount++;
       }
    }

}

