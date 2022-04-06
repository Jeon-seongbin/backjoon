package com.company21;

import java.io.*;
import java.util.*;

public class Main3 {

    public static TreeSet< Integer> myonso = new TreeSet<>();
    public static int dohyonArea = 0;
    public static int N = 0;
    public static int Q = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 첫째 줄에 구역의 개수 $N$ ($1 \leq N \leq 500\,000$)과 쿼리의 개수 $Q$ ($1 \leq Q \leq 100\,000$)가 정수로 주어진다.
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        // 둘째 줄에 길이 $N$의 수열 $A$가 주어진다. $i$번째 구역이 명소라면 $A_i$는 $1$, 그렇지 않다면 $0$이다.
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int isMyonso = Integer.parseInt(st.nextToken());
            if (isMyonso == 1) {
                myonso.add(i);
            }
        }

        for (int i = 0; i < Q; i++) {
            // 셋째 줄부터 $Q$줄에 걸쳐 본문의 쿼리가 주어진다. $3$번 쿼리는 하나 이상 존재한다.
            st = new StringTokenizer(br.readLine());
            int operator = Integer.parseInt(st.nextToken());

            if (operator == 1) {
                int ii = Integer.parseInt(st.nextToken());
                one(ii);
            } else if (operator == 2) {
                int x = Integer.parseInt(st.nextToken());
                two(x);
            } else {
                bw.write("" + three() + "\n");
//                System.out.println(three());
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    //  $1$ $i$ : $i$번 구역이 명소가 아니었다면 명소로 지정되고, 명소였다면 지정이 풀리게 된다. ($1 \leq i \leq N$)
    public static void one(int i) {
        i--;
        if (myonso.contains(i)) {
            myonso.remove(i);
        } else {
            myonso.add(i);
        }
    }

    //  $2$ $x$ : 도현이가 시계방향으로 $x$만큼 이동한다. ($1 \leq x \leq 10^9$)]
    public static void two(int x) {
        if (dohyonArea  + x <= N) {
            dohyonArea = x + dohyonArea ;
        } else if (x == 1) {
            dohyonArea = 0;
        } else if (N < dohyonArea + x) {
            dohyonArea = Math.abs(N - (dohyonArea + x)) ;
        }
    }

    //  $3$ : 도현이가 명소에 도달하기 위해 시계방향으로 최소 몇 칸 움직여야 하는 지 출력한다. 명소가 존재하지 않는 경우 $-1$을 출력한다.
    public static int three() {
        if (myonso.isEmpty()) {
            return -1;
        }
        int result = 0;
        try {
            return myonso.higher(dohyonArea);
        } catch (Exception e) {
            result = myonso.first() - dohyonArea;
            return result;
        }
    }
}
