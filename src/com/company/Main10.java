package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main10 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String userInput = s.nextLine();
        Solution so = new Solution();
        System.out.println(so.solution(userInput));
    }
}

class Solution {
    public int solution(String arg) {
        int answer = 0;
        String copyArray = arg.replace("()", "0");
        ArrayList<Character> copy = new ArrayList<Character>();

        for (int i = 0; i < copyArray.length(); i++) {
            copy.add(copyArray.charAt(i));
        }
        ArrayList<Character> stack = new ArrayList<Character>();

        for(int i = 0; i < copy.size(); i++){
            if(copy.get(i) == '('){
                stack.add(copy.get(i));
            }else if(copy.get(i) == ')'){
                stack.remove(stack.size()-1);
                answer += 1;
            }else if(copy.get(i) == '0'){
                answer += stack.size();
            }
        }
        return answer;

    }
}
