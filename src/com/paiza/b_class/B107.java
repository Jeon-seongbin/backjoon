package com.paiza.b_class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B107 {
    public static int N, M, K;
    public static int[][] cardGap;
    public static int[][] tempGap;

    public static int[] cards;

    public static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int gap = N / M;
        c = N % M;
        if (N % M != 0) {
            gap++;
            c++;
        }

        cardGap = new int[gap][M];
        tempGap = new int[gap][M];
        cards = new int[N];
        // [ 9 / 3 ] [ 3 ]


        int count = 1;
        for (int i = 0; i < gap; i++) {
            for (int j = 0; j < M; j++) {
                if (N < count) {
                    continue;
                }
                cardGap[i][j] = count;
                count++;
            }
        }

        while (K > 0) {
            int first = 0;
            for (int i = gap - 1; i >= 0; i--) {
                for (int j = 0; j < M; j++) {
                    tempGap[i][j] = cardGap[first][j];
                }
                first++;
            }

            if (c != 0) {


                count = 0;
                for (int i = 0; i < gap; i++) {
                    for (int j = 0; j < M; j++) {

                        if (tempGap[i][j] == 0) {
                            continue;
                        }
                        cards[count] = tempGap[i][j];
                        count++;

                    }
                }

                count = 0;
                for (int i = 0; i < gap; i++) {
                    for (int j = 0; j < M; j++) {
                        if(count < N){
                            tempGap[i][j] = cards[count];
                            count++;
                        }else{
                            tempGap[i][j] = 0;
                        }
                    }
                }
            }

            for (int i = 0; i < gap; i++) {
                for (int j = 0; j < M; j++) {
                    cardGap[i][j] = tempGap[i][j];
                }
            }
            K--;
        }

        for (int i = 0; i < gap; i++) {
            for (int j = 0; j < M; j++) {
                if(tempGap[i][j] != 0){
                    System.out.println(tempGap[i][j]);
                }
            }
        }

    }
}
