package com.acmicpc.season1.company19;
import java.io.*;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
//        int count = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(st.nextToken());
//        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n + 1];
        int dp[] = new int[n + 1];
        // 값의 범위의 최솟값이 1이기 때문에
        int result = 0;

//        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = 0;
        st = new StringTokenizer(br.readLine());
        // dp배열 초기화
        for(int i = 1; i <= n; i++){
            int num = Integer.parseInt(st.nextToken());
            // 입력된 배열 값 저장
            arr[i] = num;
            // 입력된 배열 값과 이전의 값들을 비교한다.
            for(int j = 0 ; j < i; j++){
                // 비교한 값보다 큰경우
                if(arr[i] > arr[j]){
                    // 비교한 값의 dp값 + 1, 기존의 dp값 중 큰 값을 저장한다.
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    // 최장 길이인 답을 구하기 위해서 result값에
                    // 지금까지 구한 dp값 중 가장 큰 값을 저장한다.
                    result = Math.max(dp[i], result);
                }
            }
        }

//        st = new StringTokenizer(br.readLine());
//
//        for (int i = 0; i < n; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//
//        for (int i = 0; i <= n; i++) {
//            dp[i] = 1;
//            for (int j = 0; j < i; j++) {
//                if (arr[j] <= arr[i] && dp[i] <= dp[j]) {
//                    dp[i] = dp[j] + 1;
//                }
//            }
//        }
//
//
//
//        int max = 0;
        for (int i : dp) {
            if (max <= i) {
                max = i;
            }
        }
//
//


        bw.write("" + max + "\n");

//        Stack<Integer> stack = new Stack<>();
//
//        for(int a = n ; 0 < a ; a--){
//            if(max == dp[a]){
//                stack.push(arr[a]);
//                max--;
//            }
//
//        }
//        while (!stack.isEmpty()){
//            bw.write(""+stack.pop() + " ");
//        }

        bw.flush();
        bw.close();
        br.close();
    }
}
