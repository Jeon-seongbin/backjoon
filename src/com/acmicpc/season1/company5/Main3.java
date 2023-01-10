package com.acmicpc.season1.company5;

/**
 곱셈 내성
 정수에 대해 '한 자리수에 맞게 하여 각 자리 숫자의 곱을 구한다'는 조작을 생각합니다.
 한 자리수의 수에 도달하는데 필요한 「조작」의 회수는, 77에서는 4회, 123456에서는 2회가 됩니다.

 그러면, 1000000이하의 정수 가운데, 한 자리수의 도달하는데 필요한 「조작」의 회수가 5회가 되는 것은 몇개인가를, 구해 주세요.
 */
public class Main3 {
    public static void main(String[] args) {
        int count = 0;


//        1, 2, 3
//        1 2, 3,
//        memoization
        // 트리 서치
        // 1 몇번 돈다
        // 2일떄 몇번 돈다
        // 3일때 몇번 돈다
        // 해시맵의 총 10만개 엘리먼트
        // 
        for (int i = 10; i <= 1000000; i++) {
            String iStr = String.valueOf(i);
            int[] iStrJari = new int[iStr.length()];


            for (int j = 0; j < iStrJari.length; j++) {
                iStrJari[j] = Integer.parseInt(iStr.charAt(j) + "");
            }
            String jari = "";
            int temp = 1;
            while (jari.length() != 2) {
                for (int jarijari : iStrJari) {

                }

            }
        }
    }
}
