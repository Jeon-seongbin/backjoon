package com.company5;

public class Main2 {
    public static void main(String[] args) {

        int sum = 0;

        for (int i = 1; i <= 33333; i++) {

            String iStr = String.valueOf(i);

            boolean isStrTrue = false;

            for (int j = 0; j < iStr.length(); j++) {
                if(isStrTrue){
                    continue;
                }
                char isThree = iStr.charAt(j);
                if (isThree == '3') {
                    sum += i;
                    isStrTrue = true;
                }
            }
            if(isStrTrue){
                continue;
            }
            if (i % 3 == 0) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

}
