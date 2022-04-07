package com.acmicpc.company10;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

// https://www.acmicpc.net/problem/1032
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        // 건수 입력
        ArrayList<String> userInputs = new ArrayList<>();

        // 문장(파일명) 입력
        for (int i = 0; i < count; i++) {
            userInputs.add(br.readLine());
        }

        // 처음에 들어갈 문자열 저장
        char[] temp = new char[userInputs.get(0).length()];

        // 문자가 다른 캐릭터의 인덱스 값을 저장할 변수 선언
        int[] questionMarkIndex = new int[userInputs.get(0).length()];

        // -1로 초기화
        Arrays.fill(questionMarkIndex, -1);

        for (int i = 0; i < count; i++) {
            String a = userInputs.get(i);
            char[] aa = a.toCharArray();

            //문자열 하나씩 비교할건데
            for (int j = 0; j < aa.length; j++) {
                // 첫번째면 비교할 문자를 저장
                if (i == 0) {
                    temp[j] = aa[j];
                } else {
                    // 두번쨰부터 문자가 다르면

                    if (temp[j] != aa[j]) {
                        // 인덱스 에 인덱스 값을 넣음
                        questionMarkIndex[j] = j;
                    }
                }
            }
        }

        // 저장된 인덱스 값 확인
        for(int i = 0 ; i < questionMarkIndex.length;i++){

            // -1 일 경우 문자 출력
            if(questionMarkIndex[i] == -1){
                bw.write(temp[i] + "");
            }else{
                // -1이 아닐경우 ? 출력
                bw.write("?");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
