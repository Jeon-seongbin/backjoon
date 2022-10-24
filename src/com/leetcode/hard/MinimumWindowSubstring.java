package com.leetcode.hard;


public class MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(minWindow1("AEFADFHBFDGHSDFGSDFHBSDDASDFASDGSDFHAGDFHDFGHCVBNCGHJSGH", "AA"));

    }

    public static String minWindow1(String s, String t) {
        String result = "";
        if (s.length() < t.length()) {
            return result;
        }
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); i++) {
            String temp = "";

            int tIndex = 0;

            boolean[] tDp = new boolean[t.length()];

            for (int j = i; j < s.length(); j++) {
                temp += s.charAt(j);
                boolean isCheck = true;
                for (int k = 0; k < t.length(); k++) {

                    if (tDp[k]) {
                        continue;
                    }
                    if (s.charAt(j) == t.charAt(k)) {
                        tDp[k] = true;
                        break;
                    }
                }
                for (boolean tt : tDp) {
                    if (!tt) {
                        isCheck = false;
                    }
                }

                if (isCheck && temp.length() < min) {
                    result = temp;
                    min = temp.length();
                }
                if (isCheck) {
                    break;
                }
            }
        }

        return result;
    }
}
