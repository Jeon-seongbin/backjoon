package com.codewars.sixKyu;

import java.util.ArrayList;
import java.util.List;

public class SmileFaces {
    public static void main(String[] args) {
        List<String> a = new ArrayList<String>();
        a.add(":)");
        a.add(":D");
        a.add(":-}");
        a.add(":-()");
        System.out.println(countSmileys(a));
    }

    public static int countSmileys(List<String> arr) {
        // Just Smile :)


        int result = 0;

        /*
        Each smiley face must contain a valid pair of eyes. Eyes can be marked as : or ;
        A smiley face can have a nose but it does not have to. Valid characters for a nose are - or ~
        Every smiling face must have a smiling mouth that should be marked with either ) or D
         */
        for (String s : arr) {
            int sLength = s.length();
            if (s.charAt(0) == ':' || s.charAt(0) == ';') {
                if (sLength == 3) {
                    if ((s.charAt(1) == '-' || s.charAt(1) == '~') && (s.charAt(2) == ')' || s.charAt(2) == 'D')) {
                        result++;
                    }
                } else if (sLength == 2) {
                    if (s.charAt(1) == ')' || s.charAt(1) == 'D') {
                        result++;
                    }
                }
            }
        }
        return result;
    }

}
