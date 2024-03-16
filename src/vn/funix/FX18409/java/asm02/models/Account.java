package vn.funix.FX18409.java.asm02.models;

public class Account {
    private String accountNumber;
    private double balance;

    public Account() {
    }

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isPremiumAccount() {
        return balance >= 10_000_000;
    }

    @Override
    public String toString() {
        return accountNumber + " |                         " + String.format("%,d", (long) balance) + "đ";
    }
}