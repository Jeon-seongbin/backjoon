package com.acmicpc.season1.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class Main12 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int inputCount = Integer.parseInt(br.readLine());  // Read user input
        TreeMap<Integer, ArrayList<Integer>> temp = new TreeMap<Integer, ArrayList<Integer>>();

        for (; inputCount > 0; inputCount--) {
            String input = br.readLine();
            String[] tempInput = input.split(" ");
            int age = Integer.parseInt(tempInput[1]);
            ArrayList<Integer> nameList = temp.get(age);
            if (nameList == null) {
                nameList = new ArrayList<>();
            }
            nameList.add(Integer.parseInt(tempInput[0]));
            temp.put(age,nameList);
        }
        temp.forEach((k, v) -> {
            Collections.sort(v);
            v.forEach( obj ->{
                System.out.println(obj + " " + k);
            });
        });

    }

}
