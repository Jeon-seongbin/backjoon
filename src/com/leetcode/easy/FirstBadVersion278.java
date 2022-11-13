package com.leetcode.easy;

public class FirstBadVersion278 {
    public static void main(String[] args) {

    }
    public static boolean isBadVersion(int i){
         return true;
    }
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        int answer = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return answer;
    }
}
