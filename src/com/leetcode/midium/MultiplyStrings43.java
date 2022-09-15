package com.leetcode.midium;

import java.math.BigDecimal;

public class MultiplyStrings43 {
    public String multiply(String num1, String num2) {
        BigDecimal num11 = new BigDecimal(num1);
        num11 = num11.multiply(new BigDecimal(num2));
        return num11.toString();
    }
}
