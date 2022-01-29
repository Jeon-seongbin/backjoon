package com.company12;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/2910
public class Main5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 이 메시지는 숫자 N개로 이루어진 수열이고, 숫자는 모두 C보다 작거나 같다.
        // 첫째 줄에 메시지의 길이 N과 C가 주어진다. (1 ≤ N ≤ 1,000, 1 ≤ C ≤ 1,000,000,000)
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        //둘째 줄에 메시지 수열이 주어진다.
        st = new StringTokenizer(br.readLine());

        // K 입력된 수열
        // V 입력된 수열 몇개 있는지
        // + 순번 LinkedHashMap
        // 순번이 보장되는지는 잘 모르겠음 해봐야알듯 -> 됨
        HashMap<Integer, Integer> hashMap = new LinkedHashMap<>();

        // 저장작업
        for (int i = 0; i < N; i++) {
            int userInput = Integer.parseInt(st.nextToken());
            int count = 0;
            if (hashMap.containsKey(userInput)) {
                count = hashMap.get(userInput);
            }
            hashMap.put(userInput, ++count);
        }

        // 빈도수가 가장 많고
        // 첫번째로 입력한 값 찾기

        // 무한루프
        while(true){

            // hashmap의 이터레이터에서 값을 뽑아냄
            Iterator iterator = hashMap.entrySet().iterator();

            //가장 큰 값의 키와 벨류를 저장하기 위한 수
            /**
             *  K 입력된 수열
             * V 입력된 수열 몇개 있는지
             */
            int maxK = 0;
            int maxV = 0;

            // 현재의 iterator의 키값과 벨류값을 저장하기 위한 수
            int K = 0;
            int V = 0;
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> mapElement = (Map.Entry) iterator.next();

                // key value저장
                K = mapElement.getKey();
                V = mapElement.getValue();

                // 어떤 수열이 가장 많이 입력 되었을 경우
                if(maxV < V){
                    //가장 큰 값의 키와 벨류를 저장
                    maxV = V;
                    maxK = K;
                }
            }

            // 입력된 횟수 만큼 루프
            for(int i = 0 ; i < maxV; i++){
                // 값을 표시
                bw.write("" + maxK + " ");
            }

            // 가장 많이 입력된 수를 제거
            hashMap.remove(maxK);

            // 해시맵이 없을 시 무한루프 탈출
            if(hashMap.isEmpty()){
                break;
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
