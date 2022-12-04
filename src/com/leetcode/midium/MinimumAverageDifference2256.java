package com.leetcode.midium;


public class MinimumAverageDifference2256 {
    public static void main(String[] args) {
//        System.out.println(minimumAverageDifference(new int[]{2, 5, 3, 9, 5, 3}));
//        System.out.println(minimumAverageDifference(new int[]{1}));
        System.out.println(minimumAverageDifference(new int[]{1, 2, 3, 4, 5}));
    }

    public int minimumAverageDifference1(int[] nums) {
        int n = nums.length;
        int ans = -1;
        int minAvgDiff = Integer.MAX_VALUE;
        long currPrefixSum = 0;
        long totalSum = 0;

        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        for (int index = 0; index < nums.length; index++) {
            currPrefixSum += nums[index];
            long leftPartAverage = currPrefixSum;
            leftPartAverage /= (index + 1);

            long rightPartAverage = totalSum - currPrefixSum;
            if (index != n - 1) {
                rightPartAverage /= (n - index - 1);
            }

            int currDifferent = (int) Math.abs(leftPartAverage - rightPartAverage);
            if (currDifferent < minAvgDiff) {
                minAvgDiff = currDifferent;
                ans = index;
            }
        }

        return ans;
    }

    public static int minimumAverageDifference(int[] nums) {
        int length = nums.length;
        int ans = -1;
        long total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        long currSum = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < length; i++) {
            currSum += nums[i];
            long leftAvg = currSum / (i + 1);

            long rightAvg = total - currSum;
            if (i != nums.length - 1) {
                rightAvg /= (length - i - 1);
            }
            int currDifferent = (int) Math.abs(leftAvg - rightAvg);
            if (currDifferent < min) {
                min = currDifferent;
                ans = i;
            }

        }


        return ans;
    }

    /*

    TLD

    public static int minimumAverageDifference1(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int index = 1;

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int first = 0;
            int last = 0;

            int j = 0;
            for (; j < index; j++) {
                first += nums[j];
            }

            if (first != 0) {
                first /= index;
            }
            int z = index;
            for (; z < nums.length; z++) {
                last += nums[z];
            }
            if (last != 0) {
                last = last / (nums.length - (index));
            }
            int a = Math.abs(first - last);
            hashMap.put(index - 1, a);
            index++;
        }

        int result = hashMap.entrySet().stream().sorted((o1, o2) -> o1.getValue() - o2.getValue()).map(Map.Entry::getKey).findFirst().get();
        return result;
    }

    */
}
