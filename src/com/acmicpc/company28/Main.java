package com.acmicpc.company28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int N;
    public static int[] board;
    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N];
        for(int i = 0 ; i < N ; i++){
            board[0] = i;
            count += putQueen(1);
        }
        System.out.println(count);
    }

    public static int putQueen(int cur_line) {
        int c_count = 0;
        if (cur_line == N) {
            return 1;
        }
        for (int i = 0; i < N; i++) {
            board[cur_line] = i;
            if (isRight(cur_line, i)) {
                c_count += putQueen(cur_line + 1);
            }
        }
        return c_count;
    }

    public static boolean isRight(int cur_line, int pos) {
        for (int i = 0; i < cur_line; i++) {
            if (board[i] == pos) {
                return false;
            }
            if (Math.abs(i - cur_line) == Math.abs(board[i] - pos)) {
                return false;
            }
        }
        return true;
    }
}
