package com.acmicpc.company;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(bf.readLine());

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(64);
        arr.add(32);
        arr.add(16);
        arr.add(8);
        arr.add(4);
        arr.add(2);
        arr.add(1);

        int count = 0;
        boolean removeFlg = false;
        int size = 0;
        boolean closeFlg = false;
        while (true) {

            if(closeFlg){
                buf.write(String.valueOf(count));
                break;
            }
            count++;

            if (removeFlg) {
                arr.remove(0);
                removeFlg = false;
                count--;
            }
            for (int i = 0; i < arr.size(); i++) {
                int temp = arr.get(i);
                if (temp == X) {
                    closeFlg = true;
//                    count--;
                    break;
                } else if (temp > X) {
                    removeFlg = true;
                    break;
                } else {
                    size += arr.get(i);
                    if (size > X) {
//                        count++;
                        size -= arr.get(i);
                        removeFlg = true;
                        break;
                    }else if (size < X){
                        count++;
                        closeFlg = false;
                    }else{
                        closeFlg = true;
                        break;
                    }
                }
            }
        }


//        int count = 0;
//
//        int createdBar = 0;
//
//        int longBar = 32;
//        int shortBar = 32;
//        int nokori = 0;
//        if(X == 32){
//            System.out.println("1");
//            return;
//        }
////        막대를 자르는 가장 쉬운 방법은 절반으로 자르는 것이다. 지민이는 아래와 같은 과정을 거쳐서 막대를 자르려고 한다.
////
////        지민이가 가지고 있는 막대의 길이를 모두 더한다. 처음에는 64cm 막대 하나만 가지고 있다. 이때, 합이 X보다 크다면, 아래와 같은 과정을 반복한다.
//
////                가지고 있는 막대 중 길이가 가장 짧은 것을 절반으로 자른다.
////                만약, 위에서 자른 막대의 절반 중 하나를 버리고 남아있는 막대의 길이의 합이 X보다 크거나 같다면, 위에서 자른 막대의 절반 중 하나를 버린다.
////        이제, 남아있는 모든 막대를 풀로 붙여서 Xcm를 만든다.
////        X가 주어졌을 때, 위의 과정을 거친다면, 몇 개의 막대를 풀로 붙여서 Xcm를 만들 수 있는지 구하는 프로그램을 작성하시오.
//
//        while (true) {
//
//        createdBar = longBar + shortBar;
//
//            count++;
//            if (X == createdBar) {
//                buf.write(String.valueOf(count));
//                break;
//            }
//            //가지고 있는 막대 중 길이가 가장 짧은 것을 절반으로 자른다.
//            nokori =  shortBar /2;
//            if(X <= longBar + nokori){
//
//                shortBar = nokori;
//            }
//
//            //만약, 위에서 자른 막대의 절반 중 하나를 버리고 shortBar
//            //남아있는 막대의 long bar 길이의 합이 X보다 크거나 같다면, 위에서 자른 막대의 절반 중 하나를 버린다.
//            if(X <=shortBar + longBar){
//
//            }
//
//        }
        buf.flush();
        buf.close();
        bf.close();
    }
}
