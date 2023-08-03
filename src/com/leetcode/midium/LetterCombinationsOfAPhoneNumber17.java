package com.leetcode.midium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber17 {
    public static void main(String[] args) {
        letterCombinations("23");
    }


    public static List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }

        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        helper(digits, 0, map, new StringBuilder(), result);

        return result;
    }

    public static void helper(String digit, int index, HashMap<Character, String> map, StringBuilder sb, ArrayList<String> result) {
        if (index == digit.length()) {
            result.add(sb.toString());
            return;
        }

        // 숫자로부터 현재 인덱스의 문자열을 구함
        String str = map.get(digit.charAt(index));

        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));

            // 현재 인덱스에서 + 1 한 게 포인트
            helper(digit, index + 1, map, sb, result);

            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
