package com.leetcode.midium;

public class ImageOverlap835 {
    public static void main(String[] args) {
        int[][] img1 = {{1, 1, 0}, {0, 1, 0}, {0, 1, 0}};
        int[][] img2 = {{0, 0, 0}, {0, 1, 1}, {0, 0, 1}};

        System.out.println(largestOverlap(img1, img2));
    }

    public static int largestOverlap(int[][] img1, int[][] img2) {
        int ans = 0;
        int n = img1.length;
        int lim = n + n - 1;

        int[][] table = new int[n + n + n - 2][n + n + n - 2];

        // setting big table
        for (int i = 0, r = n - 1; i < n; i++, r++) {
            for (int j = 0, c = n - 1; j < n; j++, c++) {
                table[r][c] = img1[i][j];
                // img1 will go to center of table
            }
        }

        // y, x -> check big table
        for (int y = 0; y < lim; y++) {
            for (int x = 0; x < lim; x++) {
                int temp = 0;

                // i, j - > check img 2
                for (int i = 0, r = y; i < n; i++, r++) {
                    for (int j = 0, c = x; j < n; j++, c++) {
                        temp += img2[i][j] & table[r][c];
                    }
                }
                ans = Math.max(ans, temp);
            }
        }
        return ans;
    }
}


