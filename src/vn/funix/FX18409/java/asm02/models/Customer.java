package vn.funix.FX18409.java.asm02.models;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private List<Account> accounts;

    public Customer() {
        this.accounts = new ArrayList<>();
    }

    public Customer(String name, String customerId) {
        super(name, customerId);
        this.accounts = new ArrayList<>();
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public boolean isPremiumAccount() {
        for (Account account : accounts) {
            if (account.isPremiumAccount()) {
                return true;
            }
        }
        return false;
    }

    public void addAccount(Account newAccount) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(newAccount.getAccountNumber())) {
                return;
            }
        }
        accounts.add(newAccount);
    }

    public double getBalance() {
        double totalBalance = 0;
        for (Account account : accounts) {
            totalBalance += account.getBalance();
        }
        return totalBalance;
    }

    public void displayInformation() {
        System.out.printf("%-15s | %-15s | %-10s | %-15s\n", getCustomerId(), getName(), (isPremiumAccount() ? "Premium" : "Normal"), String.format("%,d", (long) getBalance()) + "₫");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.printf("%-7s %-7s | %-15s   %-10s   %-15s\n", (i + 1) , accounts.get(i).getAccountNumber(), "", "", String.format("%,d", (long) accounts.get(i).getBalance()) + "₫");
        }
    }
}