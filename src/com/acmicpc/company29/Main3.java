package com.acmicpc.company29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main3 {
    public static int N, M;
    public static int[] tall;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 첫째 줄에 나무의 수 N과 상근이가 집으로 가져가려고 하는 나무의 길이 M이 주어진다. (1 ≤ N ≤ 1,000,000, 1 ≤ M ≤ 2,000,000,000)
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tall = new int[N];
        // 둘째 줄에는 나무의 높이가 주어진다. 나무의 높이의 합은 항상 M보다 크거나 같기 때문에, 상근이는 집에 필요한 나무를 항상 가져갈 수 있다. 높이는 1,000,000,000보다 작거나 같은 양의 정수 또는 0이다.
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tall[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tall);
        long result = binarySearch();
        System.out.println(result);
    }

    public static long binarySearch() {
        long start = 0;
        long end = tall[N - 1];
        long mid = 0;
        long result = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            long namu = check(mid);
            if(namu == M){
                return mid;
            }
            if(namu < M){
                end = mid - 1;
                result = end;
            }else{
                start = mid + 1;
            }
        }
        return result;
    }

    public static long check(long mid) {
        long isCutCount = 0;
        for (int i = 0; i < N; i++) {
            if(mid < tall[i] ){
                isCutCount  += tall[i] - mid;
            }
        }
        return isCutCount;
    }
}
