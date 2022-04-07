package com.acmicpc.company11;

import java.util.ArrayList;
import java.util.List;

public class Main9 {
    public static void main(String[] args) {
// https://www.hackerrank.com/challenges/one-month-preparation-kit-sparse-arrays/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D=one-month-week-one

    }
    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        // Write your code here
        List<Integer> result = new ArrayList<>();

        for(String q: queries){
            int qCount = 0;
            for(String s: strings){
                if (q.equals(s)) {

                    qCount++;
                }
            }
            result.add(qCount);
        }
        return result;
    }
}
