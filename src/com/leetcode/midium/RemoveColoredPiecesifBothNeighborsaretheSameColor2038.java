package com.leetcode.midium;

public class RemoveColoredPiecesifBothNeighborsaretheSameColor2038 {
    public static void main(String[] args) {
        winnerOfGame("AABB");
    }

    public static boolean winnerOfGame(String colors) {
        if (colors.length() <= 2) {
            return false;
        }

        int a = 0;
        int b = 0;
        for (int i = 1; i < colors.length() - 1; i++) {
          char aa=   colors.charAt(i-1);
            char bb=   colors.charAt(i);
            char cc=   colors.charAt(i+1);
            if (aa == bb && bb == cc) {
                if(bb == 'A'){
                    a++;
                }else{
                    b++;
                }
            }



            }

        return a > b;
    }

    public static boolean winnerOfGame1(String colors) {
        if (colors.length() <= 2) {
            return false;
        }

        boolean isA = true;

        for (int i = 0; i < colors.length() - 2; i++) {

            char a = colors.charAt(i);
            char b = colors.charAt(i + 1);
            char c = colors.charAt(i + 2);

            if (isA) {
                if (a == 'A') {
                    if (a == b && b == c) {
                        isA = !isA;
                        String aaa = colors.substring(0, i);
                        String bbb = colors.substring(i + 1, colors.length());

                        colors = (aaa + bbb);
                        i = -1;
                    }
                }

            } else {
                if (a == 'B') {
                    if (a == b && b == c) {
                        isA = !isA;
                        String aaa = colors.substring(0, i);
                        String bbb = colors.substring(i + 1, colors.length());

                        colors = (aaa + bbb);
                        i = -1;
                    }
                }
            }


        }

        return !isA;
    }
}
