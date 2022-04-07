package com.acmicpc.company9;
import java.io.*;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        br.readLine();
        String userInput2 = br.readLine();
        String[] arg = userInput2.split(" ");
        int count = 0;
        for (int i = 0; i < arg.length; i++) {
            for (int j = i; j < arg.length - i -1; j++) {

                long a = Long.parseLong(arg[j]);
                long b = Long.parseLong(arg[j+1]);
//                long temp;
                if(a>b) {
                    count+=1;
                }

            }
        }


        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
