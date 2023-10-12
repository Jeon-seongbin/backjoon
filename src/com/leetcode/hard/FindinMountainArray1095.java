package com.leetcode.hard;

public class FindinMountainArray1095 {
    public static void main(String[] args) {
        findInMountainArray(5, new int[]{3, 5, 3, 2, 0});
    }

    public static int findInMountainArray(int target, int[] arrays) {
        // find top index
        int topIndex = 0;
        int left = 0;
        int right = arrays.length - 1 ;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arrays[mid] < arrays[mid + 1]) {
                left = mid + 1;
                topIndex = mid + 1;
            } else {
                right = mid;
            }
        }

        // check left of top index
        left = 0;
        right = topIndex;

        while (left <= right) {
            int mid = (left + right) / 2;
            int value = arrays[mid];
            if (value < target) {
                left = mid + 1;
            } else if (value > target) {
                right = mid - 1;
            } else {
                return mid;
            }

        }

        // check right of  top index
        left = topIndex;
        right = arrays.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int value = arrays[mid];
            if (value > target) {
                left = mid + 1;
            } else if (value < target) {
                right = mid - 1;
            } else {
                return mid;
            }

        }

        return -1;
    }

    public int findInMountainArray1(int target, MountainArray mountainArr) {

        for (int i = 0; i < mountainArr.length(); i++) {
            if (mountainArr.get(i) == target) {
                return i;
            }
        }
        return -1;
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        // find top index
        int topIndex = 0;
        int left = 1;
        int right = mountainArr.length() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
                topIndex = mid + 1;
            } else {
                right = mid;
            }
        }

        // check left of top index
        left = 0;
        right = topIndex;

        while (left <= right) {
            int mid = (left + right) / 2;
            int value = mountainArr.get(mid);
            if (value < target) {
                left = mid + 1;
            } else if (value > target) {
                right = mid - 1;
            } else {
                return mid;
            }

        }

        // check right of  top index
        left = topIndex;
        right = mountainArr.length() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int value = mountainArr.get(mid);
            if (value > target) {
                left = mid + 1;
            } else if (value < target) {
                right = mid - 1;
            } else {
                return mid;
            }

        }

        return -1;
    }
}

interface MountainArray {
    int get(int index);

    int length();
}