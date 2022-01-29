package com.company9;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedHashSet;
// https://www.acmicpc.net/problem/13414
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] userInputs = br.readLine().split(" ");

        int daegi = Integer.parseInt(userInputs[0]);
        int inputCount = Integer.parseInt(userInputs[1]);

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        // 수강신청
        int count = 0;
        for (int i = 0; i < inputCount; i++) {
            String userInput = br.readLine();
            if (linkedHashSet.contains(userInput))
                linkedHashSet.remove(userInput);
            linkedHashSet.add(userInput);
        }
        Iterator<String> it = linkedHashSet.iterator();
        while (it.hasNext()) {
            bw.write(it.next() + "\n");
            if (--daegi == 0) break;
        }


        // 버튼이 비활성화 된 후
        // 먼저 규칙 1을 적용하여 클릭을 2번 이상 한 학생의 중복된 대기목록을 삭제한다.

        bw.flush();
        bw.close();
        br.close();

    }
}
