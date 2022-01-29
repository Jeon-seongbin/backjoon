package com.company13;

import java.io.*;
import java.util.ArrayList;

import java.util.Collections;
import java.util.StringTokenizer;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arrayList.add(Integer.parseInt(st.nextToken()));
            }
        }

        Collections.sort(arrayList);
        arrayList = mergeSort(arrayList,0, arrayList.size() -1);
        bw.write("" + arrayList.get(arrayList.size() - N));
        bw.flush();
        bw.close();
        br.close();
    }


    public static ArrayList<Integer> mergeSort(ArrayList<Integer> arrayList, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            arrayList = mergeSort(arrayList, low, mid);
            arrayList = mergeSort(arrayList, mid + 1, high);
            arrayList = merge(arrayList, low, mid, high);
        } else {
            return arrayList;
        }
        return arrayList;
    }

    public static ArrayList<Integer> merge(ArrayList<Integer> arrayList, int low, int mid, int high) {

        ArrayList<Integer> arrayListTemp = new ArrayList<>();
        int i = low;
        int j = mid + 1;
        int k = 0;


        while (i <= mid && j <= high) {
            if (arrayList.get(i) < arrayList.get(j)) {
                arrayListTemp.add(arrayList.get(i));
                i++;
            } else {
                arrayListTemp.add(arrayList.get(j));
                j++;
            }
            k++;
        }

        // 왼쪽이 살아있다면
        while (i <= mid) {
            arrayListTemp.add(arrayList.get(i));
            i++;
        }

        while (j <= high) {

            arrayListTemp.add(arrayList.get(j));
            j++;
        }

        k--;
        while (0 <= k) {
            arrayList.set(low + k, arrayListTemp.get(k));
            k--;
        }

        return arrayList;
    }

}
