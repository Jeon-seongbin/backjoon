package com.acmicpc.season1.company10;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        br.readLine();

        String [] as = br.readLine().split(" ");

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(Arrays.asList(as));

        System.out.println(linkedHashSet.size());


        br.close();
        bw.close();
    }
}
