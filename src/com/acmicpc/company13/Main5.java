package com.acmicpc.company13;

import java.io.*;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/23841
public class Main5 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        // N개 줄에 M개씩 그림에 대한 정보가 주어진다.
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 세팅하기
        char[][] arr = set(N, M);

        // 데칼코마니 작업 시작
        arr = decalcomania(arr, N, M);

        // 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                bw.write("" + arr[i][j]);
            }
            bw.write("\n");
        }

        bw.flush();
        br.readLine();
        br.close();
    }

    static char[][] set(int N, int M) throws IOException {
        char[][] arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            String userInputs = br.readLine();
            for (int j = 0; j < M; j++) {
                char userInput = userInputs.charAt(j);
                arr[i][j] = userInput;
            }
        }
        return arr;
    }

    static char[][] decalcomania(char[][] arr, int N, int M) {

        for (int i = 0; i < N; i++) {

            // 앞쪽 값 확인
            for (int j = 0; j < M / 2; j++) {
                // 뒷쪽 값 확인
                int index = M - j - 1;

                if (arr[i][j] == '.' && arr[i][index] != '.') {
                    arr[i][j] = arr[i][index];
                } else if (arr[i][j] != '.' && arr[i][index] == '.') {
                    arr[i][index] = arr[i][j];
                }

            }
        }

        return arr;
    }
}
