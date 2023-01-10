package com.acmicpc.season1.company3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class App5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Library library = new Library();
        ArrayList<User> users = new ArrayList<>();
        int userBorrowCount = Integer.parseInt(br.readLine());

        while (true) {
            String userInput = br.readLine();
            if (userInput.equals("open")) {
                library.setOpen(true);
            } else if (userInput.equals("close")) {
                library.setOpen(false);
            }

            String[] userInputs = userInput.split(" ");

            if (userInputs[0].equals("borrow")) {

                for(int i = 2 ; i < userInputs.length ; i++){
                    int bookId = Integer.parseInt(userInputs[i]);
                    library.borrow(bookId);
                }

            } else if (userInputs[0].equals("return")) {
                for(int i = 1 ; i < userInputs.length ; i++){
                    int bookId = Integer.parseInt(userInputs[i]);
                    library.returnToShoka(bookId);
                }

            } else if (userInputs[0].equals("reverse")) {

                int userId = Integer.parseInt(userInputs[1]);

                for(int i = 2 ; i < userInputs.length ; i++){

                }

            }

        }
    }
}

class Library {
    Library() {
        borrowedBookIdist = new ArrayList<>();
        shoka = new ArrayList<>();
        torioki = new ArrayList<>();
    }

    private boolean isOpen;
    private final ArrayList<Integer> borrowedBookIdist;
    private final ArrayList<Integer> shoka;
    private final ArrayList<Integer> torioki;

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean isOpen) {
        this.isOpen = isOpen;
        if (isOpen) {
            System.out.println("open");
        } else {
            System.out.println("close");
        }
    }

    public void borrow(int bookId) {
        borrowedBookIdist.add(bookId);
    }

    public void returnToTorioki(int bookId) {
        torioki.add(bookId);
    }

    public void returnToShoka(int bookId) {
        torioki.add(bookId);
    }

    public ArrayList<Integer> getShoka() {
        return shoka;
    }

    public ArrayList<Integer> getTorioki() {
        return torioki;
    }
}


class User {
    User() {
    }


    User(int id, int finalBorrowCount) {
        this.id = id;
        this.finalBorrowCount = finalBorrowCount;
    }

    private int id;
    private int nowBorrowCount = 0;
    private int finalBorrowCount;


    public void borrow(Library lib, int id, int[] bookId) {
        int bookLength = bookId.length;
        if (nowBorrowCount + bookLength < finalBorrowCount) {
            System.out.println("cannot");
            return;
        }

        for (int j : bookId) {
            lib.borrow(j);
            nowBorrowCount++;
        }
        System.out.println("can");

        Arrays.sort(bookId);
        System.out.println(Arrays.toString(bookId));
    }

    public void returnBook(Library lib, int[] bookId) {
        String userId = String.valueOf(bookId[0]);
        if (userId.length() == 7) {
            for (int i = 1; i < bookId.length; i++) {
                lib.returnToTorioki(bookId[i]);
                nowBorrowCount--;
            }

        } else {
            for (int j : bookId) {
                lib.returnToShoka(j);
                nowBorrowCount--;
            }
        }
    }

}
