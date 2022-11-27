package com.leetcode.midium;

public class FindTheStudentThatWillReplaceTheChalk1894 {
    public static void main(String[] args) {

    }

    public int chalkReplacer(int[] chalk, int k) {
        int index = 0;
        int sum = 0;
        while (0 <= k - chalk[index]) {
            k -= chalk[index];
            sum += chalk[index];
            if (index < chalk.length - 1) {
                index++;
            } else {
                index = 0;
                k = k % sum;
            }
        }
        return index;
    }
}
