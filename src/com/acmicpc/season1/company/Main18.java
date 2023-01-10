package com.acmicpc.season1.company;

import java.util.Scanner;

public class Main18 {

    static int[][] array;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String userInput = s.nextLine();
        String[] userInputs = userInput.split(" ");
        int row = Integer.parseInt(userInputs[0]);
        int col = Integer.parseInt(userInputs[1]);
        int rot = Integer.parseInt(userInputs[2]);

        int rowStart = 0;
        int rowEnd = row - 1;

        int colStart = 0;
        int colEnd = row - 1;

        array = new int[row][col];

        for (int i = 0; i < row; i++) {
            userInput = s.nextLine();
            String[] tempStr = userInput.split(" ");
            for (int j = 0; j < col; j++) {
                array[i][j] = Integer.parseInt(tempStr[j]);
            }
        }
        while (true) {
            int size = (rowEnd - rowStart + 1) * 2 + (colEnd - colStart + 1) * 2 - 4;
            change(rowStart, rowEnd, colStart, colEnd, rot % size);
            rowStart++;
            rowEnd--;
            colStart++;
            colStart--;
            if (rowStart > rowEnd || colStart > colEnd) break;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }


    }


    public static void change(int rowStart, int rowEnd, int colStart, int colEnd, int cnt) {
        for (int rotCount = 0; rotCount < cnt; rotCount++) {
            int temp = array[rowStart][rowEnd];
            for (int i = colStart; i < colEnd; i++) {
                array[rowStart][i] = array[rowStart][i + 1];
            }

            for (int i = rowStart; i < rowEnd; i++) { //2번
                array[i][colEnd] = array[i + 1][colEnd];
            }

            for (int j = colEnd; j > colStart; j--) { //3번
                array[rowEnd][j] = array[rowEnd][j - 1];
            }

            for (int i = rowEnd; i > rowStart; i--) { //4번
                array[i][colStart] = array[i - 1][colStart];
            }
            array[rowStart + 1][colStart] = temp;
        }
    }


}
