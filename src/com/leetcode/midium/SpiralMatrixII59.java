package com.leetcode.midium;

public class SpiralMatrixII59 {
    public static void main(String[] args) {
        generateMatrix(3);
    }

    public static int[][] generateMatrix(int n) {

        int[][] temp = new int[n][n];
        boolean[][] isVisited = new boolean[n][n];

        int status = 1;
        temp[0][0] = 1;

        isVisited[0][0] = true;

        int nowX = 0;
        int nowY = 0;

        int number = 2;
        for (int i = 2; i < n * n * 2; i++) {

            switch (status) {
                case 1:
                    if (nowY + 1 < n && !isVisited[nowX][nowY + 1]) {
                        temp[nowX][nowY + 1] = number;
                        isVisited[nowX][nowY + 1] = true;
                        nowY++;
                        number++;
                    } else {
                        status++;
                    }
                    break;
                case 2:
                    if (nowX + 1 < n && !isVisited[nowX + 1][nowY]) {
                        temp[nowX + 1][nowY] = number;
                        isVisited[nowX + 1][nowY] = true;
                        nowX++;
                        number++;
                    } else {
                        status++;
                    }
                    break;
                case 3:
                    if (nowY - 1 >= 0 && !isVisited[nowX][nowY - 1]) {
                        temp[nowX][nowY - 1] = number;
                        isVisited[nowX][nowY - 1] = true;
                        nowY--;
                        number++;
                    } else {
                        status++;
                    }
                    break;
                case 4:
                    if (nowX - 1 >= 0 && !isVisited[nowX - 1][nowY]) {
                        temp[nowX - 1][nowY] = number;
                        isVisited[nowX - 1][nowY] = true;
                        nowX--;
                        number++;
                    } else {
                        status = 1;
                    }
                    break;

            }

        }
        return temp;
    }
}
