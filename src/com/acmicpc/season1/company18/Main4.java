package com.acmicpc.season1.company18;

import java.io.*;

import java.util.StringTokenizer;

public class Main4 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


//        ArrayList<Integer> arrayList = new ArrayList<>();
        int a = Integer.parseInt(st.nextToken());

        int b = Integer.parseInt(st.nextToken());

        int c = Integer.parseInt(st.nextToken());

        bw.write(""+Math.max((int) a * b / c, (int) a / b * c));
        bw.flush();
        bw.close();
    }
}
