package com.groom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Snack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1 = br.readLine();
        String input2 = br.readLine();

        String[] input1s = input1.split(" ");
        int n = Integer.parseInt(input1s[0]);
        int K = Integer.parseInt(input1s[1]);

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        String[] input2s = input2.split(" ");

        int[] input = new int[input2s.length];

        for (int i = 0; i < input2s.length; i++) {
            input[i] = Integer.parseInt(input2s[i]);
            max = Math.max(max, input[i]);
            min = Math.min(min, input[i]);
        }
//        int cutLine = max - min;
        int cutLine = max - min;
        int[] sabunDp = new int[cutLine];
        int curFloor = cutLine - 1;
        for (; curFloor >= 0; curFloor--) {
            int temp = 0;
            for (int j : input) {
                if (curFloor + 1 < j) {
                    temp += (j - (curFloor + 1));
                }
            }
            sabunDp[curFloor] = temp;
        }
        if (sabunDp.length == 0) {
            System.out.println(0);
            return;
        }

        curFloor = sabunDp.length - 1;
        int k = K;
        int count = 0;


        for (int i = curFloor; 0 < i; i--) {


            if (sabunDp[i] - sabunDp[i - 1] <= k) {
                count++;
            }
        }


        System.out.println(count);


    }
}
