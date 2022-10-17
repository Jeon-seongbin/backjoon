package com.paiza.c_class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class dp_primer_recursive_formula_step0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> arraylist = new ArrayList<>();
        arraylist.add(0);

        int x = Integer.parseInt(st.nextToken());
        arraylist.add(x);

        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        for (int i = 2; i <= k; i++) {
            arraylist.add(arraylist.get(i - 1) + d);
        }
        System.out.println(arraylist.get(arraylist.size() - 1));
    }
}
