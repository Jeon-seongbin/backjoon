package com.company;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main15 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String userInput = s.nextLine();

        String[]userInput1 =  userInput.split(" ");
        int n = Integer.parseInt(userInput1[0]);
        int k = Integer.parseInt(userInput1[1]);

        BigDecimal nn = BigDecimal.valueOf(factorial(n));
        BigDecimal kk = BigDecimal.valueOf(factorial(k));
        BigDecimal nk = BigDecimal.valueOf(factorial(n-k));

        // int result = factorial(n) / (factorial(k) * factorial(n-k));
        // System.out.print(result);

        BigDecimal temp =  kk.multiply(nk);
        temp = nn.divide(temp);
        temp = temp.remainder(new BigDecimal(10007));
        System.out.print(temp);

    }

    static int factorial(int i){
        int result = 1;
        for(; 0 < i ; i-- ){
            result *= i;
        }
        return result;
    }
}
