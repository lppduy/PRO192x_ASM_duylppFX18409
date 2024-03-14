package vn.funix.FX18409.java.asm01;

import java.util.InputMismatchException;
import java.util.Scanner;

import static vn.funix.FX18409.java.asm01.AuthenticationService.authenticate;

public class Asm01Service {

    private static Scanner sc = new Scanner(System.in);

    public void run() {

        this.displayMenu();
        int choice = this.getValidatedChoice();

        if (choice == 1) {
            this.getCCCDFunction();
        }  else {
            System.out.println("Thoat chuong trinh");
            System.out.println("Cam on ban da su dung dich vu cua chung toi");
            sc.close();
        }

    }

    private void getCCCDFunction() {
        authenticate();
        System.out.println("Passed authentication");
    }

    private void displayMenu() {
        System.out.println("+----------+--------------------+----------+");
        System.out.println("| NGAN HANG SO | FX18409@v1.0.0            |");
        System.out.println("+----------+--------------------+----------+");
        System.out.println("| 1. Nhap CCCD                             |");
        System.out.println("| 0. Thoat                                 |");
        System.out.println("+----------+--------------------+----------+");
    }

    private int getValidatedChoice() {

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