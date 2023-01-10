package com.acmicpc.season2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1477 {

    public static int N = 0;
    public static int M = 0;
    public static int L = 0;

    public static ArrayList<Integer> SA;

    public static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //첫째 줄에 현재 휴게소의 개수 N, 더 지으려고 하는 휴게소의 개수 M, 고속도로의 길이 L이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        // 둘째 줄에 현재 휴게소의 위치가 공백을 사이에 두고 주어진다.
        st = new StringTokenizer(br.readLine());
        SA = new ArrayList<>();
        SA.add(0);
        SA.add(L);
        for (int i = 0; i < N; i++) {
            SA.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(SA);

        //가장 먼 휴계소간 거리를 최소로 하려는 것 아닌가여
        //첫째 줄에 M개의 휴게소를 짓고 난 후에 휴게소가 없는 구간의 최댓값의 최솟값을 출력한다.
        int left = 1;
        int right = L;

        while (left <= right) {
            int mid = (left + right) / 2;

            boolean isTrue = false;
            int count = 0;
            for (int i = 1; i < SA.size(); i++) {
                count += (SA.get(i) - SA.get(i - 1) - 1) / mid;
            }

            if (count > M) {
                isTrue = true;
            }

            if (isTrue) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        bw.write("" + left);
        bw.flush();
    }
    /*
    이제 이분 탐색을 시작한다. 탐색하며 찾는 값은 휴게소 간격이 되며 mid값으로 설정한다.
    can_make 함수에서 휴게소 간격을 mid로 설정했을때, 몇 개의 휴게소를 설치할 수 있는지 count하고 설치해야 하는 휴게소 개수인 M개보다 크다면 큰 범위를, 작다면 작은 범위를 이분 탐색한다.
     */
}
