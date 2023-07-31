package com.programmers.level3;

public class EssenceTriangle {
    public static void main(String[] args) {
        solution(new int[][]
                {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}
        );
    }

    public static int solution(int[][] triangle) {
        int answer = 0;
        for (int i = 1; i < triangle.length; i++) {
            triangle[i][0] += triangle[i - 1][0];
        }

        for (int i = 1; i < triangle.length; i++) {
            for (int j = 1; j < triangle[i].length; j++) {
                if (j == triangle[i].length - 1) {
                    triangle[i][j] += triangle[i - 1][j - 1];
                    continue;
                }
                triangle[i][j] = Math.max(triangle[i][j] + triangle[i - 1][j - 1], triangle[i][j] + triangle[i - 1][j]);
            }
        }

        for (int i = 0; i < triangle[triangle.length - 1].length; i++) {
            answer = Math.max(triangle[triangle.length - 1][i], answer);
        }

        return answer;
    }
}
