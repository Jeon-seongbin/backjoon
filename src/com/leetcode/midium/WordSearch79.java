package com.leetcode.midium;

public class WordSearch79 {
    public static void main(String[] args) {

        boolean result = exist(new char[][]
                        {
                                {'C', 'A', 'A'},
                                {'A', 'A', 'A'},
                                {'B', 'C', 'D'}
                        }
                , "AAB");
        System.out.println(result);
    }
    public static boolean[][] isVisited;
    public static int height = 0;
    public static int width = 0;
    public static boolean exist(char[][] board, String word) {
        height = board.length;
        width = board[0].length;
        isVisited = new boolean[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                isVisited = new boolean[height][width];
                if (board[i][j] == word.charAt(0)) {
                    boolean result = dfs(board, word, i, j, 0);
                    if (result) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || board.length <= i || j < 0 || board[0].length <= j || isVisited[i][j] || word.charAt(index) != board[i][j]) {
            return false;
        }

        isVisited[i][j] = true;

        if (dfs(board, word, i + 1, j, index + 1) ||
                dfs(board, word, i - 1, j, index + 1) ||
                dfs(board, word, i, j + 1, index + 1) ||
                dfs(board, word, i, j - 1, index + 1)) {
            return true;
        }

        isVisited[i][j] = false;
        return false;
    }
}
