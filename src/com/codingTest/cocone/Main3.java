package com.codingTest.cocone;

import java.math.BigInteger;

public class Main3 {

    public static void main(String[] args) {
        solution("1111", "8889");
    }

    public static String solution(String a, String b) {
        String temp1 = "";
        int aLength = a.length() - 1;

        BigInteger bigInteger = new BigInteger(b);

        BigInteger sum = BigInteger.ZERO;

        BigInteger carry = BigInteger.ZERO;


        while (aLength >= 0 || bigInteger.compareTo(BigInteger.ZERO) == 1 || carry.compareTo(BigInteger.ZERO) == 1) {
            sum = carry;

            if (aLength >= 0) {
                BigInteger temp = new BigInteger("" + a.charAt(aLength--));
                sum = sum.add(temp);

            }
            if (bigInteger.compareTo(BigInteger.ZERO) == 1) {

                sum = sum.add(bigInteger.mod(new BigInteger("10")));

                bigInteger = bigInteger.divide(new BigInteger("10"));

            }
            temp1 += "" + sum.mod(new BigInteger("10"));


            carry = sum.divide(new BigInteger("10"));
        }


        String result = "";
        for (int i = temp1.length() - 1; i >= 0; i--) {
            result += "" + temp1.charAt(i);
        }
        return result;
    }

}
