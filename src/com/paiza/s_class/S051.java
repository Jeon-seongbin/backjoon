package com.paiza.s_class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S051 {
    static int row = 0;
    static int damage = 0;

    static int[] koma;

    static int range = 0;
    static int min = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        damage = Integer.parseInt(st.nextToken());
        koma = new int[row];
        for (int i = 0; i < row; i++) {
            koma[i] = Integer.parseInt(br.readLine());
        }


        for (int i = 0; i < row; i++) {
            int tempDamage = 0;
            range = 0;
            for (int j = i; j < row; j++) {

                if (koma[j] == 0) {
                    tempDamage *= 2;
                } else {
                    tempDamage += koma[j];
                }

                if (tempDamage < damage) {
                    range++;
                } else {
                    break;
                }
                min = Math.max(range, min);
            }
        }

        System.out.println(min + 1);

    }
}
