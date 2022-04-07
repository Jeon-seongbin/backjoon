package com.acmicpc.company11;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

// https://www.hackerrank.com/challenges/one-month-preparation-kit-mini-max-sum/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D=one-month-week-one
/*
5개의 양의 정수가 주어지면,
 5개의 정수 중 정확히 4개를 더해서 계산할 수 있는 최소값과 최대값을 구하세요.
  그런 다음 각 최소값과 최대값을 공백으로 구분된 두 개의 긴 정수의 단일 행으로 인쇄합니다.
 */
public class Main7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] abc = br.readLine().split(" ");

        List<Integer> arrayList = new ArrayList<>();

        for (String a : abc) {
            arrayList.add(Integer.parseInt(a));
        }

        miniMaxSum(arrayList);
        br.close();
    }

    public static void miniMaxSum(List<Integer> arr) throws IOException {
        // Write your code here
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        // int 형으로 풀려고 하니 오버플로우가 발생해서 인트형의 최댓값을 두번 더해서 큰 값을 찾는 식으로 해결
        // 입력은 5개 뿐이라 완전탐색 이용
        BigDecimal checkMin = new BigDecimal(Integer.MAX_VALUE).add(new BigDecimal(Integer.MAX_VALUE));
        BigDecimal checkMax = BigDecimal.ZERO;

        for (int i = 0; i < 5; i++) {
            int ii = arr.get(i);
            for (int j = i + 1; j < 5; j++) {
                int jj = arr.get(j);
                for (int k = j + 1; k < 5; k++) {
                    int kk = arr.get(k);
                    for (int z = k + 1; z < 5; z++) {
                        int zz = arr.get(z);
                        BigDecimal check = new BigDecimal(ii).add(new BigDecimal(jj).add(new BigDecimal(kk)).add(new BigDecimal(zz)));
                        if (checkMax.compareTo(check) < 0) {
                            checkMax = check;
                        }
                        if (checkMin.compareTo(check) > 0) {
                            checkMin = check;
                        }
                    }
                }
            }
        }

        bw.write("" + checkMin + " " + checkMax);
        bw.flush();
        bw.close();

    }
}

