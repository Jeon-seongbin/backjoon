package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;

public class RelativeSortArray1122 {
    public static void main(String[] args) {

    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr2[i] == arr1[j]) {
                    arrayList.add(arr1[i]);
                    arr1[i] = -1;
                }
            }
        }
        Arrays.sort(arr1);


        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] != -1){
                arrayList.add(arr1[i]);
            }
        }

        return arrayList.stream().mapToInt(Integer::intValue).toArray();
    }
}
