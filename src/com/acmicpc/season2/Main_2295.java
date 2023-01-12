package com.acmicpc.season2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main_2295 {
    public static int N = 0;
    public static ArrayList<Integer> arrayList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arrayList = new ArrayList<>();

        N = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; i++) {
            arrayList.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(arrayList);

        int result = 0;

        for (int z = N - 1; z >= 0; z--) {
            boolean isFind = false;
            for (int i = 0; i < z - 2; i++) {
                int start = i + 1;
                int end = N - 1;

                while (start < end) {
                    int temp = arrayList.get(i) + arrayList.get(start) + arrayList.get(end);

                    if (temp > arrayList.get(z)) {
                        end--;
                    } else if (temp < arrayList.get(z)) {
                        start++;
                    } else {
                        result = arrayList.get(z);
                        isFind = true;
                        break;
                    }


                }
            }
            if (isFind) {
                break;
            }

        }

        System.out.println(result);


//        int target = arrayList.get(N - 1);
//
//        int leftIndex = 0;
//        int midIndex = 1;
//        int rightIndex = N - 1;
//
//        while (leftIndex < rightIndex) {
//
//            for (; midIndex < rightIndex; midIndex++) {
//                int left = arrayList.get(leftIndex);
//                int mid = arrayList.get(midIndex);
//                int right = arrayList.get(rightIndex);
//
//                if(target == left + mid + right ){
//
//                }
//
//            }
//        }
    }
}
