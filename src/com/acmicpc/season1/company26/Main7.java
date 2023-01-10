package com.acmicpc.season1.company26;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main7 {
    public static int xc, yc, r_1, r_2;
    public static ArrayList<PointC021> arrayList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        xc = Integer.parseInt(st.nextToken());
        yc = Integer.parseInt(st.nextToken());
        r_1 = Integer.parseInt(st.nextToken());
        r_2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int userInput = Integer.parseInt(st.nextToken());
        arrayList = new ArrayList<>();
        for (int i = 0; i < userInput; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arrayList.add(new PointC021(x, y));
        }

        int r_1Zegop = r_1 * r_1;
        int r_2Zegop = r_2 * r_2;

        for (PointC021 now : arrayList) {
            int x = now.x;
            int y = now.y;

            int a = (x - xc) * (x - xc);
            int b = (y - yc) * (y - yc);

            if(r_1Zegop <= a + b && a + b <=r_2Zegop){
                bw.write("yes\n");
            }else{
                bw.write("no\n");
            }

        }

        bw.flush();
        bw.close();
        br.close();

    }
}

class PointC021 {
    int x;
    int y;

    PointC021(int x, int y) {
        this.x = x;
        this.y = y;

    }
}
