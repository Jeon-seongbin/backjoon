package com.leetcode.midium;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses93 {
    public static void main(String[] args) {

    }

    List<String> ans = new ArrayList<>();
    String str;

    public List<String> restoreIpAddresses(String s) {
        str = s;
        helper("", 0, 0);
        return ans;
    }

    public void helper(String path, int index, int dots) {
        if (4 < dots) {
            return;
        }
        if (dots == 4 && index >= str.length()) {
            ans.add(path.substring(0, path.length() - 1));
        }

        for (int i = 1; i < 4 && index + i <= str.length(); i++) {
            String num = str.substring(index, index + i);
            if (num.charAt(0) == '0' && i != 1) {
                break;
            }
            if (Integer.parseInt(num) <= 255) {
                helper(path + str.substring(index, index + i) + ".", index + i, dots + 1);
            }
        }
    }
}
