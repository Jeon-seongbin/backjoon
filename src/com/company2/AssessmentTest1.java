package com.company2;

public class AssessmentTest1 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] image = new int[3][3];
        image[0] = new int[]{1, 1, 0};
        image[1] = new int[]{1, 0, 1};
        image[2] = new int[]{0, 0, 0};

        s.flipAndInvertImage(image);
    }
}

class Solution {
    public int[][] flipAndInvertImage(int[][] image) {

        int[][] imageTemp = new int[image.length][image[0].length];

        //horizontally
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                int indexNo = image[i].length - j - 1;
                imageTemp[i][j] = image[i][indexNo];
                if(imageTemp[i][j] == 1){
                    imageTemp[i][j] = 0;
                }else{
                    imageTemp[i][j] = 1;

                }
            }
        }
        //invert

        return imageTemp;
    }
}