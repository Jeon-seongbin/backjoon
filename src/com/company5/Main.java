package com.company5;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> i = new ArrayList<>();

        i.add(1);
        i.add(0);
        i.add(5);

        int firstIndex = 0;
        int secondIndex = 1;
        int tiredIndex = 2;

//        int sum = 0;

        //
        while(true){
            int first = i.get(firstIndex);
            int second = i.get(secondIndex);
            int thired = i.get(tiredIndex);
            int sumTemp = first + second + thired;
            i.add(sumTemp);
            if(i.size() == 31){
                break;
            }
//            sum += sumTemp;

            firstIndex++;
            secondIndex++;
            tiredIndex++;
        }

        System.out.println(i.get(30));
    }
}
