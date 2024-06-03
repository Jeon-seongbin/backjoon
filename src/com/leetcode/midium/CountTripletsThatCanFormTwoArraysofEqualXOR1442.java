package com.leetcode.midium;

public class CountTripletsThatCanFormTwoArraysofEqualXOR1442 {
    public static void main(String[] args) {

    }

    public int countTriplets(int[] arr) {
        int triplets = 0;
        for (int i = 0; i < arr.length; i++) {
            int xor = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                int result = xor ^ arr[j];
                if (result == 0){
                    triplets += j - 1;
                }
            }
        }
        return triplets;
    }

}
