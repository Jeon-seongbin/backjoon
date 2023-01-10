package com.acmicpc.season1.company9;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;

// https://www.acmicpc.net/problem/7785
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        for(int i = 0 ; i < count ; i++){
            String []userInputs= br.readLine().split(" ");
            if(userInputs[1].equals("enter")){
                linkedHashSet.add(userInputs[0]);
            }else{
                linkedHashSet.remove(userInputs[0]);
            }
        }

        String[] args1 = new String[count];

        Iterator<String> iterator = linkedHashSet.iterator();
        int counter = 0;
        while(iterator.hasNext()){
            args1[counter++] = iterator.next();
        }

        args1 = Arrays.stream(args1)
                .filter(s -> (s != null && s.length() > 0))
                .toArray(String[]::new);
        Arrays.sort(args1, Collections.reverseOrder());

        for(int i = 0 ; i < args1.length; i++){
            bw.write(args1[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();


    }
}
