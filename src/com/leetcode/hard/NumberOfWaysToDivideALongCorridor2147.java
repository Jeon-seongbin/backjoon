package com.leetcode.hard;

public class NumberOfWaysToDivideALongCorridor2147 {
    public static void main(String[] args) {

    }

    public int numberOfWays(String corridor) {
        int mod = 1000000007;

        int zero = 0;
        int one = 0;
        int two = 1;

        for ( char c : corridor.toCharArray()){
            if(c == 'S'){
                zero = one;
                int temp = one;
                one = two;
                two = temp;
            }else{
                two = (two + zero) % mod;
            }
        }

        return zero;
    }
}
