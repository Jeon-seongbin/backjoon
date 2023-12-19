package com.leetcode.easy;

public class ImageSmoother661 {
    public static void main(String[] args) {

    }

    public int[][] imageSmoother(int[][] img) {

        int[] dx = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

        int height = img.length;
        int width = img[0].length;

        int[][] result = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int totalSum = 0;
                int count = 0;
                for (int z = 0; z < 9; z++) {

                    int newX = i + dx[z];
                    int newY = j + dy[z];

                    if (newX < 0 || height <= newX || newY < 0 || width <= newY) {
                        continue;
                    }
                    totalSum += img[newX][newY];
                    count++;
                }

                result[i][j] = totalSum / count;
            }
        }
        return result;
    }

}
