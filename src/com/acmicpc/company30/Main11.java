package com.acmicpc.company30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11 {
    public static boolean[] isTeishutu;
    public static void main(String[] args) throws IOException {
        isTeishutu =new boolean[31];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 1; i <= 28; i++){
            isTeishutu[Integer.parseInt(br.readLine())] = true;
        }
        for(int i = 1; i < 31; i++){
            if(!isTeishutu[i]){
                System.out.println(i);
            }
        }
    }
}
