package com.acmicpc.company1;

public class Sort2 {
    static int[] arr = {4, 3, 7, 9, 2, 5, 99, 1, 50, 20, 30, 45};


    public static void main(String[] args) {
        qsort(arr, 0, arr.length - 1);
        printValue();
    }

    public static void qsort(int[] array, int start, int end) {
        if (start < end) {
            int index = partition(array, start, end);
            qsort(array, start, index - 1);
            qsort(array, index + 1, end);
        }
    }

    public static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int index = start;
        int i = start;
        for (; i < end; i++) {
            if (array[i] <= pivot) {
                int temp = array[i];
                array[i] = array[index];
                array[index] = temp;
                index++;
            }
        }
        int temp = array[index];
        array[index] = array[end];
        array[end] = temp;

        return index;
    }

    private static void printValue() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            builder.append(arr[i]).append(" ");
        }
        System.out.println(builder.toString());
    }

}