package com.acmicpc.company5;

public class Main1 {
    public static void main(String[] args) {


        int num = 10000000;
        int sum = 0;
        for(int i = 1 ; i <= num ; i++){
            if((num % i) == 0){
                System.out.println(i);
                sum = sum + i;
            }
        }
        System.out.println(num + "의 약수의 합 = " + sum);
    }
}