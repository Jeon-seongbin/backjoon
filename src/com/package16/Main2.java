package com.package16;

import java.io.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int userInput = Integer.parseInt(br.readLine());
		int []arr = new int[userInput + 2];

		arr[1]= 1;
		arr[2]= 2;


		for (int i = 3; i <= userInput; i++) {
			arr[i] = ( arr[i - 1] + arr[i - 2] ) % 10007 ;
		}

        bw.write("" + arr[userInput ]);
        bw.close();
        br.close();
    }

}
