package vn.funix.FX18409.java.asm02.services;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterfaceService {
    private static final String AUTHOR = "FX18409";
    private static final String VERSION = "2.0.0";
    private static Scanner sc = new Scanner(System.in);


    public int displayMenuAndGetChoice() {
        displayMenu();
        return getValidatedChoice();
    }

    public void displayMenu() {
        System.out.println("+----------+--------------------+----------+");
        System.out.println("| NGAN HANG SO | " + AUTHOR + "@" + VERSION + "             |");
        System.out.println("+----------+--------------------+----------+");
        System.out.println("| 1. Them khach hang                       |");
        System.out.println("| 2. Them tai khoan cho khach hang         |");
        System.out.println("| 3. Hien thi danh sach khach hang         |");
        System.out.println("| 4. Tim theo CCCD                         |");
        System.out.println("| 5. Tim theo ten khach hang               |");
        System.out.println("| 0. Thoat                                 |");
        System.out.println("+----------+--------------------+----------+");
    }

    public int getValidatedChoice() {
        int choice;
        do {
            try {
                System.out.print("Chuc nang:  ");
                choice = sc.nextInt();
                if (choice < 0 || choice > 5) {
                    System.out.println("+----------+--------------------+----------+");
                    System.out.println("Ban da nhap sai, xin hay nhap lai ");
                    System.out.println("| 1. Them khach hang");
                    System.out.println("| 2. Them tai khoan cho khach hang");
                    System.out.println("| 3. Hien thi danh sach khach hang");
                    System.out.println("| 4. Tim theo CCCD");
                    System.out.println("| 5. Tim theo ten khach hang");
                    System.out.println("| 0. Thoat                                 ");
                    System.out.println("+----------+--------------------+----------+");
                }
            } catch (InputMismatchException e) {
                System.out.println("+----------+--------------------+----------+");
                System.out.println("Ban da nhap sai, xin hay nhap lai ");
                System.out.println("| 1. Them khach hang");
                System.out.println("| 2. Them tai khoan cho khach hang");
                System.out.println("| 3. Hien thi danh sach khach hang");
                System.out.println("| 4. Tim theo CCCD");
                System.out.println("| 5. Tim theo ten khach hang");
                System.out.println("| 0. Thoat                                 ");
                System.out.println("+----------+--------------------+----------+");
                sc.next(); // consume the invalid input
                choice = -1; // set choice to invalid value to continue the loop
            }
        } while (choice < 0 || choice > 5);
        return choice;
    }

}