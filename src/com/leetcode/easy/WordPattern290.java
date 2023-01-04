package com.leetcode.easy;

import java.util.HashMap;

public class WordPattern290 {
    public static void main(String[] args) {

    }

    public static boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        String[] arg = s.split(" ");

        int length =  pattern.length();
        if(arg.length != length){
            return false;
        }

        for (int i = 0; i < length; i++) {
            char p = pattern.charAt(i);
            if (map.containsKey(p)) {
                String value = map.get(p);
                if (!arg[i].equals(value)) {
                    return false;
                }
            } else {
                if(map.containsValue(arg[i])){
                    return false;
                }

                map.put(p, arg[i]);
            }
        }
        return true;
    }
}
