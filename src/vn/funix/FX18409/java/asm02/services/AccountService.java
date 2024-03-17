package vn.funix.FX18409.java.asm02.services;

import vn.funix.FX18409.java.asm02.models.Account;

import java.util.InputMismatchException;
import java.util.Scanner;

import static vn.funix.FX18409.java.asm02.Asm02.bank;
public class AccountService {

    private static Scanner sc = new Scanner(System.in);

    public static Account createAccountForCustomer(){
        String accountNumber = getAccountNumberFromUser();
        double accountBalance = getAccountBalanceFromUser();
        double validatedAccountBalance = validateAccountBalance(accountBalance);

        return new Account(accountNumber, validatedAccountBalance);
    }

    private static String getAccountNumberFromUser() {
        System.out.println("Nhap ma STK gom 6 chu so");
        String accountNumber = sc.next();
        while(!checkAccountNumber(accountNumber)) {
            System.out.println("STK chua chinh xac hoac da ton tai vui long nhap lai: ");
            accountNumber = sc.next();
        }
        return accountNumber;
    }

    private static double getAccountBalanceFromUser() {
        System.out.println("Nhap so du: ");
        double accountBalance = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                accountBalance = sc.nextDouble();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Nhap khong hop le. Vui long nhap mot so.");
                sc.next(); // clear the invalid input
            }
        }
        return accountBalance;
    }

    private static double validateAccountBalance(double accountBalance) {
        while(accountBalance < 50000) {
            System.out.println("So du tai khoan khong duoc thap hon 50,000đ, vui long nhap lai");
            accountBalance = sc.nextDouble();
        }
        return accountBalance;
    }

    private static boolean checkAccountNumber(String accountNumber) {
        boolean checkAccountNumber = true;
        // Id.length = 12 character.
        if(accountNumber.length() != 6) checkAccountNumber = false;

        // Id is Number or notNumber?
        for (int i = 0; i < accountNumber.length(); i++) {
            String s = "";
            s += accountNumber.charAt(i);
            int intValue;
            try {
                intValue = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                checkAccountNumber = false;
                break;
            }
        }

        for (int i = 0; i < bank.getCustomers().size(); i++) {
            for (int j = 0; j < bank.getCustomers().get(i).getAccounts().size(); j++) {
                if(accountNumber.equals(bank.getCustomers().get(i).getAccounts().get(j).getAccountNumber())) checkAccountNumber = false;
            }
        }
        return checkAccountNumber;
    }
}