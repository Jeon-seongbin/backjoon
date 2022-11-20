package com.acmicpc.package24;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main3 {

    public static int N;
    public static TreeSet<Integer> treeSet;
    public static int[] numsInput;
    public static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        N = Integer.parseInt(br.readLine());


        nums = new int[N];
        treeSet = new TreeSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            treeSet.add(temp);
            nums[i] = temp;
        }
        numsInput = new int[treeSet.size()];

        int size = treeSet.size();
        for (int i = 0; i < size; i++) {
            numsInput[i] = treeSet.pollFirst();
        }

        for (int i = 0; i < N; i++) {
            bw.write("" + binarySearch(nums[i], size));
            if (i != N - 1) {
                bw.write(" ");
            }
        }
        bw.flush();
        bw.close();
        br.close();

    }


    public static int binarySearch(int input, int size) {
        int low = 0;
        int high = size - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (input == numsInput[mid]) {
                return mid;
            } else if (numsInput[mid] < input) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;

    }
}

//5
//        2 4 -10 4 -9
//        예제 출력 1
//        2 3 0 3 1