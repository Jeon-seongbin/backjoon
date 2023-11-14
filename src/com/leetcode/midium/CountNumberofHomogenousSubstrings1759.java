package com.leetcode.midium;

public class CountNumberofHomogenousSubstrings1759 {
    public static void main(String[] args) {

    }

    public int countHomogenous(String s) {
        int answer = 0;
        int MOD = (int) 1e9 + 7;
        int currStrick = 0;
        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(i) == 0 || s.charAt(i) == s.charAt(i - 1) ){
                currStrick++;
            }else{
                currStrick = 1;
            }
            answer = (answer+ currStrick) / MOD;
        }
        return answer;
    }
}
