package com.company5;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Main5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String z = br.readLine();
        String input1 = br.readLine();

        z = br.readLine();
        String input2 = br.readLine();
//        List<String> input1s= Arrays.stream(input1.split(" ")).sorted().collect(Collectors.toList());
        List<Integer> input1sArrayList = new ArrayList<>();
        String[] input1s = input1.split(" ");

        for (String s : input1s) {
            input1sArrayList.add(Integer.parseInt(s));
        }
        input1sArrayList = input1sArrayList.stream().sorted().collect(Collectors.toList());
        String[] input2s = input2.split(" ");


        HashMap<String, Integer> input2Map = new HashMap<>();

        for (String s : input2s) {
            input2Map.put(s, 0);
        }

        for (String s : input1s) {
            int a = binSearch(input1sArrayList, Integer.parseInt(s));
            if(a != -1){
                String ss = String.valueOf(s);
                if (input2Map.containsKey(ss)) {
                    input2Map.put(ss, input2Map.get(ss) + 1);
                }
            }

        }

        for(String s: input2s){
            bw.write(input2Map.get(s)+" ");
        }
        bw.flush();
        bw.close();
    }


    public static int binSearch(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size() - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (target == arr.get(mid)) {
                return mid;
            } else if (target < arr.get(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
