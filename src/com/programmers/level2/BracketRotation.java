package com.programmers.level2;

import java.util.Stack;

public class BracketRotation {
    public static void main(String[] args) {
        solution("}}}");
    }

    public static int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            String temp = s;

            String tempFirst = temp.substring(0, i);
            String tempTwice = temp.substring(i, s.length());

            String newS = tempTwice + tempFirst;

            Stack<Character> bigBracket = new Stack<>();


            boolean ispushed = false;
            for (int j = 0; j < newS.length(); j++) {
                ispushed = false;
                char tempNewS = newS.charAt(j);

                if (tempNewS == '(' || tempNewS == '{' || tempNewS == '[') {
                    bigBracket.push(tempNewS);
                    ispushed = true;
                    continue;
                }

                if (!bigBracket.isEmpty()) {
                    char oneChar = bigBracket.peek();

                    if (tempNewS == ')' && oneChar == '(') {
                        bigBracket.pop();
                    }


                    if (tempNewS == '}' && oneChar == '{') {
                        bigBracket.pop();
                    }

                    if (tempNewS == ']' && oneChar == '[') {
                        bigBracket.pop();
                    }
                }
            }
            if (bigBracket.size() == 0 && ispushed) {
                answer++;
            }
        }
        
        return answer;
    }


}
