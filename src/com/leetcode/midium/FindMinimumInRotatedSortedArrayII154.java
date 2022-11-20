package com.leetcode.midium;

public class FindMinimumInRotatedSortedArrayII154 {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3, 1, 3}));
    }

    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0;
        int end = nums.length - 1;

        if (nums[start] < nums[end]) {
            return nums[start];
        }

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] < nums[end]) {
                end = mid;
                // end を利用
            } else if (nums[mid] > nums[end]) {
                // right side is rotated, expecting smallest number between mid + 1 <=  end;
                // 5 6 7 8 9 1 2 3
                start = mid + 1;
            } else {
                // reduce duplicate
                // 5 6 7 8 9 1 1 3
                end--;
            }
        }
        return nums[end];
    }
}


//    must not early stop when n[lo] <= n[hi] like the case of unique array

//First, we take
//        low (lo) as 0
//        high (hi) as nums.length-1
//
//        By default, if nums[lo]<nums[hi] then we return nums[lo] because the array was never rotated, or is rotated n times
//
//        After entering while loop, we check
//        if nums[mid] > nums[hi] => lo = mid + 1 because the minimum element is in the right half of the array
//        else if nums[mid] < nums[hi] => hi = mid because the minimum element is in the left half of the array
//        else => hi-- dealing with duplicate values
//        then we return nums[hi]

