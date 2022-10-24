package com.leetcode.midium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters1239 {
    public int result = 0;

    public int maxLength(List<String> arr) {
        if (arr == null || arr.size() == 0) {
            return 0;
        }
        dfs(arr, "", 0);
        return result;
    }

    public void dfs(List<String> arr, String path, int index) {
        boolean isUnique = isUnique(path);

        if (isUnique) {
            result = Math.max(result, path.length());
        }

        if (!isUnique && arr.size() == index) {
            return;
        }

        for (int i = index; i < arr.size(); i++) {
            dfs(arr, path + arr.get(i), i + 1);
        }
    }

    public boolean isUnique(String path) {
        Set<Character> set = new HashSet<>();

        for (char c : path.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }

}
