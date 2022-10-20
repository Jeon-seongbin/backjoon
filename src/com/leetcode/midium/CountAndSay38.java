package com.leetcode.midium;

public class CountAndSay38 {
    public String countAndSay(int n) {
        String nn = "" + n;
        if (n != 1) {
            nn = countAndSay(n - 1);
        } else {
            return nn;
        }


        String result = "";

        int count = 1;
        char nnn = nn.charAt(0);

        for (int i = 1; i < nn.length(); i++) {
            if (nn.charAt(i) == nnn) {
                count++;
            } else {
                result += ("" + count + "" + nn.charAt(i - 1));
                nnn = nn.charAt(i);
                count = 1;
            }

        }


        result += count + "" + nn.charAt(nn.length() - 1);
        return result;

    }
}
