package com.company8;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

// https://www.acmicpc.net/problem/1406
// 에디터

public class Main4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split("");
        LinkedList<Character> list = new LinkedList<>();
        ListIterator<Character> iter = list.listIterator();

        int len = str.length;
        for (int i = 0; i < len; i++) {
            iter.add(str[i].charAt(0));
        }

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            char[] input = br.readLine().toCharArray();

            switch (input[0]) {
                case 'L':
                    if (iter.hasPrevious())
                        iter.previous();
                    break;
                case 'D':
                    if (iter.hasNext())
                        iter.next();
                    break;
                case 'B':
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                default:
                    iter.add(input[2]);
                    break;
            }
        }
        for (char c : list) {
            wr.write(c);
        }
        wr.flush();
    }
}
