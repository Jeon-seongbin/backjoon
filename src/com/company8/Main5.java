package com.company8;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

// https://www.acmicpc.net/problem/5397
// 키로거
public class Main5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<String> result = new ArrayList<>();
        int count = Integer.parseInt(br.readLine());

        while (count-- > 0) {
            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> iter = list.listIterator();
            String userInput = br.readLine();
            char[] userInputs = userInput.toCharArray();
            for (int i = 0; i < userInputs.length; i++) {
                char temp = userInputs[i];
                switch (temp) {
                    case '<':
                        if (iter.hasPrevious())
                            iter.previous();
                        break;
                    case '>':
                        if (iter.hasNext())
                            iter.next();
                        break;
                    case '-':
                        if (iter.hasPrevious()) {
                            iter.previous();
                            iter.remove();
                        }
                        break;
                    default:
                        iter.add(temp);
                        break;

                }
                StringBuilder temp1 = new StringBuilder();
                if (userInputs.length == i + 1) {
                    for (char c : list) {
                        temp1.append(c);
                    }
                    result.add(temp1.toString());
                }
            }
        }
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).length(); j++) {
                wr.write(result.get(i).charAt(j));
            }
            wr.write("\n");
        }
        wr.flush();
        wr.close();
        br.close();
    }
}