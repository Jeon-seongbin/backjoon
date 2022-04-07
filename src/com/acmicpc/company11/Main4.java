package com.acmicpc.company11;

import java.io.*;

//https://www.acmicpc.net/problem/2581
public class Main4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int start = Integer.parseInt(br.readLine());
        int end = Integer.parseInt(br.readLine());
        int sum = 0;
        int saisho = -1;
        if (start == 1 && end == 1) {
            bw.write("-1");
            bw.flush();
            return;
        }

        for (; start <= end; start++) {
            if (start == 1) {
                continue;
            }

            int yaksu = 0;
            for (int i = 2; i < start; i++) {
                if (start % i == 0) {
                    yaksu++;
                }
                if (1 <= yaksu) {
                    break;
                }

            }
            if (yaksu == 0) {
                if (saisho == -1) {
                    saisho = start;
                }
                sum += start;
            }
        }

        if (saisho != -1) {
            bw.write("" + sum + "\n");
        }

        bw.write("" + saisho + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
