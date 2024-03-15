package vn.funix.FX18409.java.asm01.service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterfaceService {
    private static final String AUTHOR = "FX18409";
    private static final String VERSION = "1.0.0";
    private static Scanner sc = new Scanner(System.in);


    public int displayMenuAndGetChoice() {
        displayMenu();
        return getValidatedChoice();
    }

    public void displayMenu() {
        System.out.println("+----------+--------------------+----------+");
        System.out.println("| NGAN HANG SO | " + AUTHOR + "@" + VERSION + " |");
        System.out.println("+----------+--------------------+----------+");
        System.out.println("| 1. Nhap CCCD                             |");
        System.out.println("| 0. Thoat                                 |");
        System.out.println("+----------+--------------------+----------+");
    }

    public int getValidatedChoice() {

        int choice;
        do {
            try {
                System.out.print("Chuc nang:  ");
                choice = sc.nextInt();
                if ((choice != 0) && (choice != 1)) {
                    System.out.println("-------------------------------------------");
                    System.out.println("Ban da nhap sai, xin hay nhap lai ");
                    System.out.println("| 1. Nhap CCCD");
                    System.out.println("| 0. Thoat");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ban da nhap sai, xin hay nhap lai ");
                System.out.println("| 1. Nhap CCCD");
                System.out.println("| 0. Thoat");
                sc.next(); // consume the invalid input
                choice = -1; // set choice to invalid value to continue the loop
            }
        } while ((choice != 0) && (choice != 1));
        return choice;
    }

}