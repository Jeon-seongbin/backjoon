package com.leetcode.easy;

import java.util.*;

public class NumberOfStudentsUnableToEatLunch1700 {
    public static void main(String[] args) {

    }

    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> sandwichesQueue = new LinkedList<>();
        Queue<Integer> studentsQueue = new LinkedList<>();

        for (int s : students) {
            studentsQueue.add(s);
        }

        for (int s : sandwiches) {
            sandwichesQueue.add(s);
        }

        int size = students.length;

        int a = 0;
        while (true) {
            if (Objects.equals(studentsQueue.peek(), sandwichesQueue.peek())) {
                studentsQueue.poll();
                sandwichesQueue.poll();
                size--;
                a = 0;
            }
            if (size == 0) {
                break;
            }

            if (!Objects.equals(studentsQueue.peek(), sandwichesQueue.peek())) {

                int tempStudent = studentsQueue.poll();
                studentsQueue.add(tempStudent);
                a++;
            }

            if (studentsQueue.size() == a) {
                break;
            }

        }
        return a;
    }
}
