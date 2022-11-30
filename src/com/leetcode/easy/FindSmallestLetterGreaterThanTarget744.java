package com.leetcode.easy;

public class FindSmallestLetterGreaterThanTarget744 {
    public static void main(String[] args) {
        System.out.println(nextGreatestLetter(new char[]{'e', 'e', 'e', 'e', 'e', 'e', 'n', 'n', 'n', 'n'}, 'e'));
    }

    public static char nextGreatestLetter(char[] letters, char target) {

        int letters_length = letters.length;
        int low = 0;
        int high = letters_length - 1;

        if (target < letters[low] || target >= letters[high]) {
            return letters[low];
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target < letters[mid]) {
                high = mid - 1;
            }
            if (letters[mid] <= target) {
                low = mid + 1;
            }
        }
        return letters[low];
    }

    public static char nextGreatestLetter1(char[] letters, char target) {

        for (int i = 0; i < letters.length; i++) {

            if (target < letters[i]) {
                return letters[i];
            }

            if (target == letters[i]) {
                if (letters.length <= i + 1) {
                    return letters[0];
                }
                if (letters[i + 1] == target) {
                    continue;
                }
                return letters[++i];
            }
        }
        return letters[0];
    }
}
