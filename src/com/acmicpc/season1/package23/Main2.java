package com.acmicpc.season1.package23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// https://www.acmicpc.net/submit/14425/50692414
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int userInputCount = Integer.parseInt(st.nextToken());
        int selectCount = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();

        for(int i = 0; i < userInputCount; i++){
            set.add(br.readLine());
        }

        int sameCount = 0 ;
        for(int i = 0; i < selectCount; i++){
            if( set.contains(br.readLine())){
                sameCount++;
            }
        }

        System.out.println(sameCount);

    }
}
