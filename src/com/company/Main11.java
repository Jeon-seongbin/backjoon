package com.company;

import java.io.*;


public class Main11 {
    static int[] result;
    static int[] arg;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf = new BufferedWriter(new OutputStreamWriter(System.out));

        int inputCount = Integer.parseInt(br.readLine());  // Read user input


        arg = new int[inputCount];
        result = new int[inputCount];

        for (int i = 0; i < inputCount; i++) {
            int input = Integer.parseInt(br.readLine());  // Read user input
            arg[i] = input;
        }

        mergeSort(arg, 0, arg.length - 1);


        for (int i = inputCount-1; i >= 0; i--) {
            buf.write(String.valueOf(arg[i]));
            buf.write("\n");
        }
        buf.flush();
    }

    public static void merge(int[] arr, int mStart, int middle, int nEnd) {
        int iStart = mStart;
        int jMiddle1 = middle + 1;
        int kMergeIndex = mStart;

        while (iStart <= middle && jMiddle1 <= nEnd) {
            if (arr[iStart] <= arr[jMiddle1]) {
                result[kMergeIndex] = arr[iStart];
                iStart++;
            } else {
                result[kMergeIndex] = arr[jMiddle1];
                jMiddle1++;
            }
            kMergeIndex++;
        }

        if (iStart >= jMiddle1) {
            for (int t = jMiddle1; t <= nEnd; t++) {
                result[kMergeIndex] = arr[t];
                kMergeIndex++;
            }
        } else {
            for (int t = iStart; t <= middle; t++) {
                result[kMergeIndex] = arr[t];
                kMergeIndex++;
            }
        }

        for (int i = mStart; i <= nEnd; i++) {
            arr[i] = result[i];
        }
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(arr, start, middle);
            mergeSort(arr, middle + 1, end);
            merge(arr, start, middle, end);
        }
    }


}
