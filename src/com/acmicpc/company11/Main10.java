package com.acmicpc.company11;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
// https://www.hackerrank.com/challenges/one-month-preparation-kit-diagonal-difference/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D=one-month-week-one
public class Main10 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] inputs = bufferedReader.readLine().split(" ");
            List<Integer> arrayList = new ArrayList<>();
            for(String s : inputs){
                int zz = Integer.parseInt(s);

                arrayList.add(zz);
            }
            arr.add(arrayList);
        }

        int result = diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here

        int squareSize = arr.size();
        int ii = 0;
        int jj = arr.size() - 1;

        int slash = 0;
        int backSlash = 0;
        for (int i = 0; i < squareSize; i++) {
            for (int j = 0; j < squareSize; j++) {
                if(i == j){
                    slash += arr.get(i).get(j);
                }

                if (jj == j) {
                    backSlash += arr.get(ii).get(jj);
                }
            }
            ii++;
            jj--;
        }

        return Math.abs(slash - backSlash);
    }
}
