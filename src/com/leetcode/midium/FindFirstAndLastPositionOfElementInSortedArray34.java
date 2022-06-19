package com.leetcode.easy.midium;

public class FindFirstAndLastPositionOfElementInSortedArray34 {
    public static void main(String[] args) {
        searchRange(new int[]{5,7,7,8,8,10}, 8);
    }

    public static int[] searchRange(int[] nums, int target) {

        int start = 0;
        int end = nums.length;
        int pivot = 0;
        while(start <= end){
            pivot = start +(end - start) / 2;
            if(nums[pivot] == target){
                break;
            }
            if(nums[pivot] < target){
                start = pivot + 1;
            }else{
                end = pivot - 1;
            }
        }

        System.out.println(pivot);


        return new int[]{-1, -1};
    }
}
