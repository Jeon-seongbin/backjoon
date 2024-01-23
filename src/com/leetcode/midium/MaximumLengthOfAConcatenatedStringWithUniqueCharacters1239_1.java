package com.leetcode.midium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters1239_1 {
    public static int result = 0;
    public static int maxLength(List<String> arr) {
        dfs(arr, "", 0);

        return result;
    }

    public static void dfs(List<String> arr, String path, int index) {
        boolean isUnique = isUnique(path);

        if(isUnique){
            result = Math.max(result, path.length());
        }

        if (!isUnique || arr.size() == index) {
            return;

        }
        for (int i = index; i < arr.size(); i++) {
            dfs(arr, path + arr.get(i), i);
        }
    }

    public static boolean isUnique(String path) {
        HashSet<Character> hashSet = new HashSet<>();
        for (char p : path.toCharArray()) {
            if (hashSet.contains(p)) {
                return false;
            }
            hashSet.add(p);
        }
        return true;
    }


}
