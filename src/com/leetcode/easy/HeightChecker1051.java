package com.leetcode.easy;

import java.util.Arrays;

public class HeightChecker1051 {
    public static void main(String[] args) {
        heightChecker(new int[]{3,2,1,5,4});
    }

    public static int heightChecker(int[] heights) {

        int[] heightsTemp = new int[heights.length];

//
//        for(int i = 0 ; i < heights.length; i++){
//            heightsTemp[i] = heights[i];
//        }
//
        System.arraycopy(heights, 0, heightsTemp, 0, heights.length);


        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < i; j++) {
                if (heights[i] < heights[j]) {
                    int temp = heights[i];
                    heights[i] = heights[j];
                    heights[j] = temp;
                }
            }
        }

        int result = 0;
        for(int i = 0 ; i < heights.length;i++){
            if(heights[i] == heightsTemp[i]){
                result++;
            }
        }
        return heights.length-result ;
    }
}
