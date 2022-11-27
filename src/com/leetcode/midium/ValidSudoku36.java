package com.leetcode.midium;

import java.util.HashSet;

public class ValidSudoku36 {
    public static void main(String[] args) {

    }

    public static boolean isValidSudoku(char[][] board) {
        HashSet<Character> cHashSet = new HashSet<>();
        HashSet<Character> rHashSet = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    continue;
                } else {
                    if (!rHashSet.add(board[i][j])) {
                        return false;
                    }
                }
            }
            rHashSet = new HashSet<>();
        }
        for (int j = 0; j < board.length; j++) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] == '.') {
                    continue;
                } else {
                    if (!cHashSet.add(board[i][j])) {
                        return false;
                    }
                }
            }
            cHashSet = new HashSet<>();
        }


        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!isCheck(board, i, j)) {
                    return false;
                }
            }
        }


        return true;
    }

    public static boolean isCheck(char[][] board, int i, int j) {
        HashSet<Character> set3 = new HashSet<>();
        for (int m = i; m < 3 + i; m++) {
            for (int n = j; n < j + 3; n++) {
                if (board[m][n] == '.') {
                    continue;
                }
                if (!set3.add(board[m][n])) {
                    return false;
                }
            }
        }

        return true;
    }


}
