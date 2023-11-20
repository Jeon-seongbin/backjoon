package com.leetcode.midium;

import java.util.ArrayList;
import java.util.List;

public class MinimumAmountOfTimeToCollectGarbage2391 {
    public static void main(String[] args) {
        garbageCollection(new String[]{"G", "P", "GP", "GG"}, new int[]{2, 4, 3});
    }

    public static int garbageCollection(String[] garbage, int[] travel) {

        int totalMin = 0 ;

        int currentTimeMin = 0;

        totalMin = garbage[0].length();

        ArrayList<Integer> lastGarbageIndices = new ArrayList<>(List.of(-1,-1,-1));


        for(int houseIndex = 1; houseIndex < garbage.length; houseIndex++ ){
            totalMin += garbage[houseIndex].length();

            // Update the indices of the last occurrence of each type of garbage
            if (garbage[houseIndex].contains("M")) {
                lastGarbageIndices.set(0, houseIndex - 1);
            }
            if (garbage[houseIndex].contains("P")) {
                lastGarbageIndices.set(1, houseIndex - 1);
            }
            if (garbage[houseIndex].contains("G")) {
                lastGarbageIndices.set(2, houseIndex - 1);
            }
        }

        for(int travelIndex = 0 ; travelIndex < travel.length; travelIndex++){
            currentTimeMin+= travel[travelIndex];

            for (int truckIndex = 0; truckIndex < 3; truckIndex++) {
                if (lastGarbageIndices.get(truckIndex) == travelIndex) {
                    totalMin += currentTimeMin;
                }
            }
        }

        return (int) totalMin;
    }
}
