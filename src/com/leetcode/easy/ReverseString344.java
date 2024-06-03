package com.leetcode.easy;

public class ReverseString344 {
    public static void main(String[] args) {

    }
    public void reverseString(char[] s) {
        char [] ss = new char [s.length];

        int index = 0;
        for(int i = s.length - 1 ; i >=0 ; i--){
            ss[index] = s[i];
            index++;
        }

        for(int i = 0 ; i < s.length ; i++){
            s[i] = ss[i];
        }


    }
}
