package com.acmicpc.season1.company19;

import java.io.*;
import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        Arrays.sort(arr);
       int spyA = 0;
       int spyB = 0;
        for (int i = 0; i < 8; i++) {
            for (int k = i + 1; k < 9; k++) {
                if(sum - arr[i]- arr[k] == 100){
                    spyA = k;
                    spyB = i;
                    break;
                }
            }
        }
        for(int j = 0; j < arr.length; j++) { // 진짜 난쟁이 키 출력
            if(j == spyA || j == spyB) //주의
                continue;
            System.out.println(arr[j]);
        }
//        bw.write("\n");
//        bw.flush();
    }
}
