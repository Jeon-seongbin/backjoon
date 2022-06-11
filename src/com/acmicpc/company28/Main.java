package com.acmicpc.company28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;

    static int N, ans; // 체스판 크기와 정답
    static int[] board; // 체스판 배열인데 배열의 각 인덱스를 열이라 생각하고 원소의 값을 행이라 생각할 것이라 1차원 배열로도 가능하다.

    // 해당 위치에 퀸을 놓을 수 있는지 검사하는 함수
    public static boolean isPossible(int col) {
        for (int i = 0; i < col; i++) {
            // 해당 열의 행과 열이 일치하면 놓을 수 없다(이 행에는 퀸이 이미 있음)
            if (board[col] == board[i])
                return false;
                // 이미 퀸이 있는 위치의 대각선 방향으로도 놓을 수 없다.(행과 열의 차가 같으면 대각선 방향임)
            else if (Math.abs(col - i) == Math.abs(board[col] - board[i]))
                return false;
        }

        // 위 두 케이스에 걸리지 않으면 퀸을 놓을 수 있다.
        return true;
    }

    public static void nQueen(int depth) {
        if (N == depth) {
            // 이번에 탐색할 열이 체스판의 크기와 같으면 모든 퀸을 놓은 것이니까 경우의 수 증가 & 리턴
            ans++;
            return;
        }

        for (int i = 0; i < N; i++) {
            // 현재 열에 퀸을 놓는다.
            board[depth] = i;

            // 이번 열이 놓을 수 있는 위치라면 재귀호출
            if (isPossible(depth))
                nQueen(depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        board = new int[N];

        nQueen(0);
        bw.write(Integer.toString(ans));

        bw.close();
    }
}