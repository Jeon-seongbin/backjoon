package com.acmicpc.company28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
    // 첫째 줄에 특성값이 0에 가장 가까운 용액을 만들어내는 세 용액의 특성값을 출력한다.
    // 출력해야하는 세 용액은 특성값의 오름차순으로 출력한다. 특성값이 0에 가장 가까운 용액을 만들어내는 경우가 두 개 이상일 경우에는 그 중 아무것이나 하나를 출력한다.
    public static int N;
    public static long[] input, result;
    public static long start;
    public static long min = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        input = new long[N];
        result = new long[3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            input[i] = temp;
        }

        // 투 포인터는 소팅이 필수
        Arrays.sort(input);

        for (int i = 0; i < N; i++) {
            int left = i + 1; // 가장 왼쪽을 제외하고 그 다음부터 순회
            int right = N - 1;
            while (left < right) {
                long sum = input[i] + input[left] + input[right];
                long diff = Math.abs(sum);
                if (diff < min) {
                    min = diff;
                    result[0] = input[i];
                    result[1] = input[left];
                    result[2] = input[right];
                }
                if (sum > 0) { // 차이가 0보다 크다. 오른쪽 원소를 한 칸 앞으로
                    right--;
                } else { // 차이가 0보다 작다. 왼쪽 원소를 한 칸 앞으로
                    left++;
                }
            }
        }
        System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }
}
