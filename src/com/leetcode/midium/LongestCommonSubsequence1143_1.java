package com.leetcode.midium;

public class LongestCommonSubsequence1143_1 {
    public static void main(String[] args) {

    }

    public int longestCommonSubsequence(String text1, String text2) {

        String text1Temp = "";
        String text2Temp = "";



        int text1Size = text1.length();
        int text2Size = text2.length();


        if(text1Size < text2Size){
            text1Temp = text2;
            text2Temp = text1;
        }else{
            text1Temp = text1;
            text2Temp = text2;
        }

        int count = 0;
        for (int i = 0; i < text2Temp.length(); i++) {
            for (int j = i; j < text1Temp.length(); j++) {
                if(text1Temp.charAt(i) == text2Temp.charAt(j)){
                    count++;
                    break;
                }
            }
        }

        return count;
    }
}
